package br.com.TDD.pedido;

import br.com.TDD.ingredientes.Ingrediente;

import java.util.TreeMap;

public class Cardapio {
    private final TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        if(preco <= 0){
            throw new IllegalArgumentException("Preço do ítem inválido");
        } else {
            this.precos.put(ingrediente, preco);
        }
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        if(preco <= 0){
            throw new IllegalArgumentException("Preço do ítem inválido");
        }
        if(!precos.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ítem inexistente");
        } else {
            precos.put(ingrediente, preco);
            return true;
        }
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
        if(!precos.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ítem inexistente");
        } else {
            precos.remove(ingrediente);
            return true;
        }
    }

    public Double buscarPreco(Ingrediente ingrediente){
        if(!precos.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ítem inexistente");
        }
        return precos.get(ingrediente);
    }
    @Override
    public String toString() {
        return this.precos.toString();
    }
}
