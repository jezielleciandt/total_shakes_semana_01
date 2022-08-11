package pedido;

import java.io.*;

public class Cliente implements Serializable, FazPedido {

    private static final long serialVersionUID = 1L;

    private final int id;
    private final String nome;
    private final String email;

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void serializarCliente(){
        try(var outputStream = new ObjectOutputStream(new FileOutputStream("Cliente-" + this.id + ".txt"))){

            outputStream.writeObject(this);

        }catch (Exception e){

            System.out.println("Nao foi possivel desserializar");
            e.printStackTrace();
        }
    }

    public static Cliente desserializarCliente(int id){
        try(var objectInputStream = new ObjectInputStream(new FileInputStream("Cliente-" + id + ".txt"))){

            return (Cliente) objectInputStream.readObject();

        }catch (Exception e){

            System.out.println("Nao foi possivel desserializar");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void serializarPedido(Pedido pedido) {
        try(var outputStream = new ObjectOutputStream(new FileOutputStream("Pedido-" + pedido.getId() + ".txt"))){

            outputStream.writeObject(pedido);

        }catch (Exception e){

            System.out.println("Nao foi possivel desserializar");
            e.printStackTrace();
        }
    }

    @Override
    public  Pedido desserializarPedido(int id){
        try(var objectInputStream = new ObjectInputStream(new FileInputStream("Pedido-" + id + ".txt"))){

            return (Pedido) objectInputStream.readObject();

        }catch (Exception e){

            System.out.println("Nao foi possivel desserializar");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        if (id != cliente.id) return false;
        if (!nome.equals(cliente.nome)) return false;
        return email.equals(cliente.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nome.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nome + " - " + this.email;
    }


}
