package pedido;

import java.io.*;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String email;

    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void serializarCliente(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("Cliente-" + this.id + ".txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        }catch(Exception e){
            System.out.println("Nao foi possivel serializar");
        }finally{
            if(oos != null){
                try{
                    oos.close();
                }catch(IOException e){
                    System.out.println("Nao foi possivel fechar o arquivo");
                }
            }
        }
    }

    public static Cliente desserializarCliente(int id){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("Cliente-" + id + ".txt");
            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked") Cliente cliente = (Cliente) ois.readObject();

            return cliente;
        }catch(Exception e){
            System.out.println("Nao foi possivel desserializar");
            return null;
        }finally{
            if(ois != null){
                try{
                    ois.close();
                }catch(IOException e){
                    System.out.println("Nao foi possivel fechar o arquivo");
                }
            }
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
