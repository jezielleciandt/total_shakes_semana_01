package pedido;

import ingredientes.Ingrediente;

import java.util.TreeMap;

public class Cardapio {

    private final TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
       //TODO
        return true;
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
       //TODO
        return true;
    }

    public Double buscarPreco(Ingrediente ingrediente){
        //TODO
        return 0.0;
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

}
