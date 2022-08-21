package br.com.TDD.pedido;

import br.com.TDD.ingredientes.Ingrediente;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Cardapio {

    private TreeMap<Ingrediente, Double> precos;

    public Cardapio() {
        this.precos = new TreeMap<>();
    }

    public NavigableMap<Ingrediente, Double> getPrecos() {
        return this.precos.descendingMap();
    }

    public void adicionarIngrediente(Ingrediente ingrediente, Double preco) {
        if (preco > 0) {
            precos.put(ingrediente, preco);
        } else {
            throw new IllegalArgumentException("Preco invalido.");
        }
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente, Double preco) {

        if (!precos.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        } else if(preco > 0) {
            precos.put(ingrediente, preco);
        } else {
            throw new IllegalArgumentException("Preco invalido.");
        }
        return true;
    }

    public boolean removerIngrediente(Ingrediente ingrediente) {
        if (precos.containsKey(ingrediente)) {
            precos.remove(ingrediente);
        } else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return true;
    }

    public Double buscarPreco(Ingrediente ingrediente) {
        Double preco = precos.get(ingrediente);
        if (preco != null) {
            precos.get(ingrediente);
        } else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
        return preco;
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }
}
