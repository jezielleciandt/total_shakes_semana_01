package pedido;

import ingredientes.Ingrediente;

import java.util.TreeMap;

public class Cardapio {
    private TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        if(preco <= 0){
            throw new IllegalArgumentException("Preco invalido.");
        }
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        if(preco <= 0){
            throw new IllegalArgumentException("Preco invalido.");
        }
        if(precos.keySet().contains(ingrediente)){
            precos.put(ingrediente, preco);
            return true;
        }
        else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
        if(precos.keySet().contains(ingrediente)){
            precos.remove(ingrediente);
            return true;
        }
        else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
    }

    public Double buscarPreco(Ingrediente ingrediente){
        if(precos.keySet().contains(ingrediente)){
            return precos.get(ingrediente);
        }
        else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}