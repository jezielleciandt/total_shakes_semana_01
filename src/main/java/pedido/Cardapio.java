package pedido;

import ingredientes.Adicional;
import ingredientes.Ingrediente;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cardapio {

    private final TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        if(preco <= 0){
            throw new IllegalArgumentException("Preco invalido.");
        }
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){

        if(!precos.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");

        }else if(preco <= 0){
            throw new IllegalArgumentException("Preco invalido.");
        }else{
            precos.put(ingrediente, preco);
            return true;
        }
    }

    public boolean removerIngrediente(Ingrediente ingrediente){

        if(!precos.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");

        } else{
            precos.remove(ingrediente);
            return true;
        }
    }

    public Double buscarPreco(Ingrediente ingrediente){
        if(!precos.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");

        } else{
            return precos.get(ingrediente);
        }

    }

    public TreeMap<Adicional, Double> getAdicionais() {
         TreeMap<Adicional, Double> adicionais = new TreeMap<>();

        this.precos.forEach((ingrediente, preco) -> {
            if(ingrediente instanceof Adicional){
                adicionais.put((Adicional) ingrediente, preco);
            }
        });
        return adicionais;
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }
}
