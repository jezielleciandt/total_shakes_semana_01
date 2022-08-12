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
        validarPrecoPositivo(preco);
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        validarPrecoPositivo(preco);
        if(!precos.containsKey(ingrediente)) throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        if(precos.replace(ingrediente, preco)!=null) return true;
        else throw new RuntimeException("Erro ao atualizar ingrediente.");
    }

    public boolean removerIngrediente(Ingrediente ingrediente) {
        if(!precos.containsKey(ingrediente)) throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        if(precos.remove(ingrediente)!=null) return true;
        else throw new RuntimeException("Erro ao remover ingrediente.");
    }

    public Double buscarPreco(Ingrediente ingrediente){
        if(!precos.containsKey(ingrediente)) throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        return precos.get(ingrediente);
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

    public void validarPrecoPositivo(Double preco){
        if(preco<=0) throw new IllegalArgumentException("Preco invalido.");
    }
}
