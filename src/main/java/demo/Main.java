package demo;

import ingredientes.Adicional;
import ingredientes.Ingrediente;
import ingredientes.base.Base;
import ingredientes.base.TipoBase;
import ingredientes.fruta.Fruta;
import ingredientes.fruta.TipoFruta;
import ingredientes.topping.TipoTopping;
import ingredientes.topping.Topping;
import pedido.Cardapio;
import pedido.Cliente;
import produto.Shake;
import produto.TipoTamanho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner leitor = new Scanner(System.in);
    static Cardapio cardapio = instanciarCardapio();

    public static void main(String[] args) {
        Cliente cliente = new Cliente(1,"Pedro","pedro@email.com");

        System.out.println("O que deseja? \n[1] Ver cardápio | [2] Montar Pedido | [0] Sair ->");
        int opcao = leitor.nextInt();

        while(opcao != 0){
            switch (opcao){
                case 1 : System.out.println(cardapio +"\n==============================================================");
                    break;
                case 2: fazerPedido();
                    break;
                default : System.out.println("Por favor digite uma opção válida!!!!!");
            }

            System.out.println("O que deseja? \n[1] Ver cardápio | [2] Montar Pedido | [0] Sair ->");
            opcao = leitor.nextInt();
        }
    }

    private static void fazerPedido() {
        System.out.println("=================================================\n"
                +"Selecione a base do Shake: \n[1] Sorvete | [2] Iogurte | [3] Leite | [0] Sair ->");
        int opcaoBase = leitor.nextInt();
        Base base = montarBase(opcaoBase);

        System.out.println("====================================================\n"
                +"Selecione a fruta do Shake: \n[1] BANANA | [2] MORANGO | [3] ABACATE | [0] Sair ->");
        int opcaoFruta = leitor.nextInt();
        Fruta fruta = montarFruta(opcaoFruta) ;

        System.out.println("====================================================\n"
                +"Selecione o topping do Shake: \n[1] AVEIA | [2] MEL | [3] CHOCOLATE | [0] Sair -> ");
        int opcaoTopping = leitor.nextInt();
        Topping topping = montarTopping(opcaoTopping);

        System.out.println("=====================================================\n"
                +"Qual o tamanho do Shake: \n[1] Pequeno | [2] Médio | [3] Grande | [0] Sair ->");
        int opcaoTamanho = leitor.nextInt();
        TipoTamanho tamanho = montarTamanho(opcaoTamanho);

        System.out.println("====================================================\n"
                +"Quer colocar alguns adicionais ? \n[1] Sim | [2] Não | [0] Sair ->");
        int opcaoAdicionais = leitor.nextInt();
        List<Adicional> adicionais = montarAdicionais(opcaoAdicionais);

        Shake shake = new Shake(base, fruta, topping, adicionais, tamanho);
        System.out.println("Shake montado: " + shake);
        System.out.println("Total do pedido: ");

    }

    private static List<Adicional> montarAdicionais(int opcaoAdicionais) {
        List<Adicional> adicionais = new ArrayList<>();

        if(opcaoAdicionais == 1){
            System.out.println("[1] Ver Opções de adicionais | [2] Adicionar | [3] Ver adicionais escolhidos "
                    + "| [4] Finalizar adição | [0] Sair -> ");
            int adicionalOpt = leitor.nextInt();

            while(adicionalOpt != 4){

                if(adicionalOpt == 1){
                    System.out.println(cardapio.getAdicionais());

                }else if(adicionalOpt == 2){
                    System.out.println("Qual tipo do adicional: \n[1] Fruta | [2] Topping");
                    int opcaoDoAdicional = leitor.nextInt();
                    escolherAdicionais(opcaoDoAdicional, adicionais);

                } else if(adicionalOpt == 3){
                    System.out.println(adicionais);

                } else if(adicionalOpt == 0){
                    System.exit(0);
                }

                System.out.println("[1] Ver Opções de adicionais | [2] Adicionar | [3] Ver adicionais escolhidos "
                        + "| [4] Finalizar adição | [0] Sair -> ");
                adicionalOpt = leitor.nextInt();
            }

            return adicionais;

        }else if(opcaoAdicionais == 2){
            return adicionais;

        }else {
            System.out.println("Digite uma opção válida");
            return adicionais;
        }
    }

    private static void escolherAdicionais(int opcaoDoAdicional, List<Adicional> adicionais){

        switch (opcaoDoAdicional){
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("[1] Banana | [2] Morango | [3] Abacate | [0] Sair ->");
                int optAdicionalFruta = leitor.nextInt();
                adicionais.add(selecionarFruta(optAdicionalFruta));
                break;
            case 2:
                System.out.println("[1] Aveia | [2] Mel | [3] Chocolate | [0] Sair ->");
                int optAdicionalTopping = leitor.nextInt();
                adicionais.add(selecionarTopping(optAdicionalTopping));
                break;
            case 3:
                System.out.println(adicionais);
                break;
            case 4:
                return;
            default:
                System.out.println("Informe uma opção válida!!! \n [1] Escolher fruta adicional | [2] Escolher Topping adicional"
                        + "| [3] Ver adicionais escolhidos | [4] Finalizar adição");
                int opcao = leitor.nextInt();
                montarAdicionais(opcao);
        }

    }

    private static Base montarBase(int opcaoBase) {

        Base base = selecionarBase(opcaoBase);

        System.out.println("Confirmar base:\n[1] Sim | [2] Escolher outra base");
        int confirmarBase = leitor.nextInt();

        while(confirmarBase != 1){
            System.out.println("Selecione a base do Shake: \n[1] Sorvete | [2] Iogurte | [3] Leite | [0] Sair ->");
            int opcaoOutraBase = leitor.nextInt();
            base = selecionarBase(opcaoOutraBase);
            System.out.println("Confirmar base:\n[1] Sim | [2] Escolher outra base ");
            confirmarBase = leitor.nextInt();
        }

        return base;
    }

    private static Topping montarTopping(int opcaoTopping) {
        Topping topping = selecionarTopping(opcaoTopping);

        System.out.println("Confirmar topping:\n[1] Sim | [2] Escolher outro topping");
        int confirmarTopping = leitor.nextInt();

        while(confirmarTopping != 1){
            System.out.println("Selecione o topping do Shake: \n[1] AVEIA | [2] MEL | [3] CHOCOLATE | [0] Sair ->");
            int opcaoOutroTopping = leitor.nextInt();
            topping = selecionarTopping(opcaoOutroTopping);
            System.out.println("Confirmar topping:\n[1] Sim | [2] Escolher outro topping");
            confirmarTopping = leitor.nextInt();
        }

        return topping;
    }

    private static Fruta montarFruta(int opcaoFruta) {
        Fruta fruta = selecionarFruta(opcaoFruta);

        System.out.println("Confirmar fruta:\n[1] Sim | [2] Escolher outra fruta");
        int confirmarFruta = leitor.nextInt();

        while(confirmarFruta != 1){
            System.out.println("Selecione a fruta do Shake: \n[1] BANANA | [2] MORANGO | [3] ABACATE | [0] Sair ->");
            int opcaoOutraFruta = leitor.nextInt();
            fruta = selecionarFruta(opcaoOutraFruta);
            System.out.println("Confirmar fruta:\n[1] Sim | [2] Escolher outra fruta");
            confirmarFruta = leitor.nextInt();
        }

        return fruta;
    }

    private static TipoTamanho montarTamanho(int opcaoTamanho) {

        TipoTamanho tamanho = selecionarTamanho(opcaoTamanho);

        System.out.println("Confirmar Tamanho:\n[1] Sim | [2] Escolher outro tamanho");
        int confirmarTamanho = leitor.nextInt();

        while(confirmarTamanho != 1){
            System.out.println("Selecione o tamanho do Shake: \n[1] Pequeno | [2] Médio | [3] Grande | [0] Sair ->");
            int opcaoOutroTamanho = leitor.nextInt();
            tamanho = selecionarTamanho(opcaoOutroTamanho);
            System.out.println("Confirmar tamanho:\n[1] Sim | [2] Escolher outra tamanho ");
            confirmarTamanho = leitor.nextInt();
        }

        return tamanho;
    }

    private static TipoTamanho selecionarTamanho(int opcaoTamanho) {
        switch (opcaoTamanho){
            case 0: System.exit(0);
                break;
            case 1:
                System.out.println("Tamanho escolhido: Pequeno");
                return TipoTamanho.P;
            case 2:
                System.out.println("Tamanho escolhido: Médio");
                return TipoTamanho.M;
            case 3:
                System.out.println("Tamanho escolhido: Grande");
                return TipoTamanho.G;
            default:
                System.out.println("Informe uma opção válida!!! \n[1] Pequeno | [2] Médio | [3] Grande | [0] Sair ->");
                opcaoTamanho = leitor.nextInt();
                selecionarTamanho(opcaoTamanho);
        }
        return null;
    }

    private static Base selecionarBase(int opcaoBase) {
        switch (opcaoBase){
            case 0: System.exit(0);
                break;
            case 1:
                System.out.println("Base escolhida: SORVETE");
                return new Base(TipoBase.SORVETE);
            case 2:
                System.out.println("Base escolhida: IOGURTE");
                return new Base(TipoBase.IOGURTE);
            case 3:
                System.out.println("Base escolhida: LEITE");
                return  new Base(TipoBase.LEITE);
            default:
                System.out.println("Informe uma opção válida!!! \n[1] Sorvete | [2] Iogurte | [3] Leite | [0] Sair ->");
                opcaoBase = leitor.nextInt();
                selecionarBase(opcaoBase);
        }

        return null;
    }

    private static Fruta selecionarFruta(int opcaoFruta) {
        switch (opcaoFruta){
            case 0: System.exit(0);
                break;
            case 1:
                System.out.println("Fruta escolhida: BANANA");
                return new Fruta(TipoFruta.BANANA);
            case 2:
                System.out.println("FRUTA escolhida: MORANGO");
                return new Fruta(TipoFruta.MORANGO);
            case 3:
                System.out.println("FRUTA escolhida: ABACATE");
                return new Fruta(TipoFruta.ABACATE);
            default:
                System.out.println("Informe uma opção válida!!! \n[1] Banana | [2] Morango | [3] Abacate | [0] Sair ->");
                opcaoFruta = leitor.nextInt();
                selecionarFruta(opcaoFruta);
        }

        return null;
    }

    private static Topping selecionarTopping(int opcaoTopping) {
        switch (opcaoTopping){
            case 0: System.exit(0);
                break;
            case 1:
                System.out.println("TOPPING escolhido: AVEIA");
                return new Topping(TipoTopping.AVEIA);
            case 2:
                System.out.println("TOPPING escolhido: MEL");
                return new Topping(TipoTopping.MEL);
            case 3:
                System.out.println("TOPPING escolhido: CHOCOLATE");
                return new Topping(TipoTopping.CHOCOLATE);
            default:
                System.out.println("Informe uma opção válida!!! \n[1] Aveia | [2] Mel | [3] Chocolate | [0] Sair ->");
                opcaoTopping = leitor.nextInt();
                selecionarTopping(opcaoTopping);
        }

        return null;
    }

    private static Cardapio instanciarCardapio() {
        Cardapio cardapio = new Cardapio();
        Ingrediente sorvete = new Base(TipoBase.SORVETE);
        Ingrediente iogurte = new Base(TipoBase.IOGURTE);
        Ingrediente leite = new Base(TipoBase.LEITE);
        Adicional banana = new Fruta(TipoFruta.BANANA);
        Adicional morango = new Fruta(TipoFruta.MORANGO);
        Adicional abacate = new Fruta(TipoFruta.ABACATE);
        Adicional mel = new Topping(TipoTopping.MEL);
        Adicional aveia = new Topping(TipoTopping.AVEIA);
        Adicional chocolate = new Topping(TipoTopping.CHOCOLATE);

        cardapio.adicionarIngrediente(sorvete,10.0);
        cardapio.adicionarIngrediente(iogurte,8.0);
        cardapio.adicionarIngrediente(leite,6.0);
        cardapio.adicionarIngrediente(banana,5.0);
        cardapio.adicionarIngrediente(morango,7.5);
        cardapio.adicionarIngrediente(abacate,4.5);
        cardapio.adicionarIngrediente(mel,1.0);
        cardapio.adicionarIngrediente(aveia, 3.0);
        cardapio.adicionarIngrediente(chocolate, 20.0);

        return cardapio;
    }
}
