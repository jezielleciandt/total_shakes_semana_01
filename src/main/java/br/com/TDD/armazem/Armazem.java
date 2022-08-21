package br.com.TDD.armazem;

import br.com.TDD.ingredientes.Ingrediente;

import java.util.TreeMap;

public class Armazem {

    private TreeMap<Ingrediente, Integer> estoque;

    public Armazem() {
        this.estoque = new TreeMap<>();
    }

    public TreeMap<Ingrediente, Integer> getEstoque() {
        return estoque;
    }

    public void cadastrarIngredientesEmEstoque(Ingrediente ingrediente) {

        if (!estoque.containsKey(ingrediente)) {
            estoque.put(ingrediente, 0);
        } else {
            throw new IllegalArgumentException("Ingrediente já cadastrado.");
        }

    }

    public void descartarIngredienteEmEstoque(Ingrediente ingrediente) {

        if (estoque.containsKey(ingrediente)) {
            estoque.remove(ingrediente);
        } else {
            throw new IllegalArgumentException("Ingrediente não encontrado.");
        }

    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {

        if (estoque.containsKey(ingrediente) && quantidade > 0) {
            Integer quantidadeEstoque = estoque.get(ingrediente);
            estoque.replace(ingrediente, quantidadeEstoque + quantidade);

        } else if (!estoque.containsKey(ingrediente)) {
            throw new IllegalArgumentException("Ingrediente não encontrado.");

        } else {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {

        Integer quantidadeEstoque = estoque.get(ingrediente);
        if (!estoque.containsKey(ingrediente)) {
            throw new IllegalArgumentException("Ingrediente não encontrado.");
        } else if (quantidade > 0) {
            estoque.replace(ingrediente, quantidadeEstoque - quantidade);
        } else if (quantidade == quantidadeEstoque) {
            estoque.remove(ingrediente);
        } else {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {

        Integer quantidade;

        if (estoque.containsKey(ingrediente)) {
            quantidade = estoque.get(ingrediente);
        } else {
            throw new IllegalArgumentException("Ingrediente não encontrado.");
        }

        return quantidade;
    }

}
