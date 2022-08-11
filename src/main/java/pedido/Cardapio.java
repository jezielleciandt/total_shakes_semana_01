package pedido;

import ingredientes.Ingrediente;

import java.util.Comparator;
import java.util.TreeMap;

public class Cardapio {
    private TreeMap<Ingrediente, Double> precos;

    public Cardapio() {
        this.precos = new TreeMap<>(new Comparator<Ingrediente>() {
            @Override
            public int compare(Ingrediente o1, Ingrediente o2) {
                return o1.obterTipo().toString().compareTo(o2.obterTipo().toString());
            }
        });
    }

    public TreeMap<Ingrediente, Double> getPrecos() {
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente, Double preco) {
        if (preco > 0) {
            precos.put(ingrediente, preco);
        } else {
            throw new IllegalArgumentException("Preco invalido.");
        }
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente, Double preco) {
        if (precos.containsKey(ingrediente)) {
            if (preco > 0) {
                precos.put(ingrediente, preco);
                return true;
            } else {
                throw new IllegalArgumentException("Preco invalido.");
            }
        } else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
    }

    public boolean removerIngrediente(Ingrediente ingrediente) {
        if (precos.containsKey(ingrediente)) {
            precos.remove(ingrediente);
            return true;
        } else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
    }

    public Double buscarPreco(Ingrediente ingrediente) {
        Double preco = precos.getOrDefault(ingrediente, 0.0);
        if (preco > 0) {
            return preco;
        } else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
