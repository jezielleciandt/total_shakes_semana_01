package application.impl;

import application.Application;
import ingredientes.*;
import pedido.Cliente;
import pedido.ItemPedido;
import pedido.Pedido;
import produto.Shake;
import produto.TipoTamanho;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Supplier;

public class ApplicationImpl implements Application {

    private static final ApplicationImpl soleInstance = new ApplicationImpl();
    private Set<Pedido> pedidos;
    private Map<Integer, Adicional> opcoesAdicionais;
    private int autoincrementClientId;
    private int autoincrementPedidoId;

    private ApplicationImpl(){
        this.initializeOpcoesAdicionaisTable();
        this.pedidos = new HashSet<>();
    }

    public static ApplicationImpl getSoleInstance() {
        return soleInstance;
    }

    public Iterator<Pedido> getPedidos(){
        return Collections.unmodifiableCollection(pedidos).iterator();
    }

    public Pedido addPedido(){
        System.out.println("\nBem-vindo ao TOTAL SHAKE. Vamos montar o seu pedido:\n");
        Cliente cliente = addCliente();
        Scanner scan = new Scanner(System.in);
        List<ItemPedido> itensPedidos = new ArrayList<>(10);
        do{
            itensPedidos.add(addItemPedido());
            System.out.println("\n\nDeseja adicionar um novo shake? SIM = 1 e NÃO = 2. Digite a sua escolha");
        } while (!(scan.nextInt() <= 0));
        Pedido pedido = new Pedido(++autoincrementPedidoId, itensPedidos, cliente);
        pedidos.add(pedido);
        return pedido;
    }

    private Cliente addCliente(){
        System.out.println("Digite o seu Nome e email: ");
        Scanner scan = new Scanner(System.in);
        String nome = scan.nextLine();
        String email = scan.nextLine();
        return new Cliente(++autoincrementClientId, nome, email);
    }

    private ItemPedido addItemPedido(){
        Scanner scan = new Scanner(System.in);
        Shake shake = addShake();
        System.out.println("\nQuantos Shakes vocês quer?\n");
        int quantidade = scan.nextInt();
        while (quantidade <= 0){
            System.out.println("A quantidade escolhida deve ser 1 ou mais");
            quantidade = scan.nextInt();
        }
        return new ItemPedido(shake, quantidade);
    }

    private Shake addShake(){
        System.out.println("\n\nMonte o seu shake com as seguintes opções do cardápio:\n\n");
        Scanner scan = new Scanner(System.in);
        Base base = escolherBase.get();
        Fruta fruta = escolherFruta.get();
        Topping topping = escolherTopping.get();
        TipoTamanho tipoTamanho = escolherTamanho.get();
        System.out.println("\n\nDeseja adicionais no seu shake? \n 1 - SIM \n 2 - NÃO\n");
        if (scan.nextInt() == 2){
            return new Shake(base, fruta, topping, tipoTamanho);
        }
        return new Shake(base, fruta, topping, escolherAdicionais.get(), tipoTamanho);
    }

    private Supplier<String> stringfiedCardapioTamanho = () -> "OPÇÕES DE TAMANHO: \nP\nM\nG";

    private Supplier<String> stringfiedCardapioBase = () -> "OPÇÕES DE BASE: \n" +
            "1 - Iogurte - R$ 10.00\n" +
            "2 - Sorvete - R$ 5.00\n";

    private Supplier<String> stringfiedCardapioFruta = () -> "OPÇÕES DE FRUTA: \n" +
            "1 - Banana - R$ 1.00\n" +
            "2 - Morango - R$ 10.00\n";

    private Supplier<String> stringfiedCardapioTopping = () -> "OPÇÕES DE TOPPING: \n" +
            "1 - Aveia - R$ 2.00\n" +
            "2 - Chocolate - R$ 4.00\n" +
            "3 - Mel - R$ 3.00\n";

    private Supplier<String> stringfiedCardapioAdicionais = () -> "OPÇÕES DE ADICIONAL: \n" +
            "1 - Aveia - R$ 2.00\n" +
            "2 - Chocolate - R$ 4.00\n" +
            "3 - Mel - R$ 3.00\n" +
            "4 - Banana - R$ 2.50\n" +
            "5 - Morango - R$ 4.00\n";

    private void initializeOpcoesAdicionaisTable(){
        opcoesAdicionais = new HashMap<>(5);
        opcoesAdicionais.put(1, new Topping(TipoTopping.Aveia));
        opcoesAdicionais.put(2, new Topping(TipoTopping.Chocolate));
        opcoesAdicionais.put(3, new Topping(TipoTopping.Mel));
        opcoesAdicionais.put(4, new Fruta(TipoFruta.Banana));
        opcoesAdicionais.put(5, new Fruta(TipoFruta.Morango));
    }

    private Supplier<Base> escolherBase = () -> {
        Scanner scan = new Scanner(System.in);
        System.out.println(stringfiedCardapioBase.get());
        int base = scan.nextInt();
        while (base != 1 && base != 2){
            System.out.println("Opção não disponível. Digite uma opção disponível no cardápio");
            base = scan.nextInt();
        }
        if(base == 1){
            return new Base(TipoBase.Iorgute);
        }
        return new Base(TipoBase.Sorvete);
    };

    private Supplier<Topping> escolherTopping = () -> {
        Scanner scan = new Scanner(System.in);
        System.out.println(stringfiedCardapioTopping.get());
        int topping = scan.nextInt();
        while (topping != 1 && topping != 2 && topping != 3){
            System.out.println("Opção não disponível. Digite uma opção disponível no cardápio");
            topping = scan.nextInt();
        }
        if(topping == 1){
            return new Topping(TipoTopping.Aveia);
        }
        if(topping == 2){
            return new Topping(TipoTopping.Chocolate);
        }
        return new Topping(TipoTopping.Mel);
    };

    private Supplier<Fruta> escolherFruta = () -> {
        Scanner scan = new Scanner(System.in);
        System.out.println(stringfiedCardapioFruta.get());
        int fruta = scan.nextInt();
        while (fruta != 1 && fruta != 2){
            System.out.println("Opção não disponível. Digite uma opção disponível no cardápio");
            fruta = scan.nextInt();
        }
        if(fruta == 1){
            return new Fruta(TipoFruta.Banana);
        }
        return new Fruta(TipoFruta.Morango);
    };

    private Supplier<List<Adicional>> escolherAdicionais = () ->{
        Scanner scan = new Scanner(System.in);
        System.out.println(stringfiedCardapioAdicionais.get());
        List<Adicional> adicionais = new ArrayList<>(5);
        List<Integer> opts = Arrays.asList(1, 2, 3, 4, 5);
        do{
            System.out.println("\nEscolha o adicional: \n");
            int opcaoDoAdicional = scan.nextInt();
            while(!opts.contains(opcaoDoAdicional)){
                System.out.println("\nDigite uma opção válida:\n");
                opcaoDoAdicional = scan.nextInt();
            }
            adicionais.add(opcoesAdicionais.get(opcaoDoAdicional));
            System.out.println("\nDeseja adicionar outro tipo de adicional? Se não, digite N. Se sim, digite S.");
        } while (scan.next().toUpperCase().charAt(0) != 'N');
        return adicionais;
    };

    private Supplier<TipoTamanho> escolherTamanho = () -> {
        Scanner scan = new Scanner(System.in);
        System.out.println(stringfiedCardapioTamanho.get());
        char tipoTamanho = scan.nextLine().toUpperCase().charAt(0);
        while (tipoTamanho != 'P' && tipoTamanho != 'M' && tipoTamanho != 'G'){
            System.out.println("Opção não disponível. Digite uma opção disponível no cardápio");
            tipoTamanho = scan.nextLine().charAt(0);
        }
        return TipoTamanho.getTipoTamanho(tipoTamanho);
    };

    @Override
    public void serializarPedidos(){
        if(pedidos == null || pedidos.isEmpty()){
            throw new RuntimeException("Lista vazia!");
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream("pedido"+ LocalDate.now()+ LocalTime.now().getMinute() +".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);){
            objectOutputStream.writeObject(pedidos);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public Iterator<Pedido> desserializarPedidos(LocalDate localDateOfSerialization, int minuteOfSerialization){
        Set<Pedido> pedidos = null;
        try(FileInputStream fileInputStream = new FileInputStream("pedido"+localDateOfSerialization+minuteOfSerialization+".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){
            pedidos = (Set<Pedido>) objectInputStream.readObject();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
        return Collections.unmodifiableCollection(pedidos).iterator();
    }
}
