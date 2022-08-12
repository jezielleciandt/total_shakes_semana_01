package pedido;

import ingredientes.Adicional;
import ingredientes.Ingrediente;

import java.util.ArrayList;
import java.util.Map;

public class Pedido{

    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        double total= 0;
        for(ItemPedido item : itens){
            double itemPreco = 0;
            itemPreco+=(cardapio.buscarPreco(item.getShake().getBase())*item.getShake().getTipoTamanho().getMultiplicador());
//            itemPreco+=cardapio.getPrecos().get(item.getShake().getFruta());
//            itemPreco+=cardapio.getPrecos().get(item.getShake().getTopping());
            for(Adicional adicional : item.getShake().getAdicionais()){
                for(Map.Entry<Ingrediente, Double> entry : cardapio.getPrecos().entrySet()) {
                    if(entry.getKey().obterTipo().toString().equals(adicional.obterTipo().toString())){
                        itemPreco+=entry.getValue();
                        break;
                    }
                }
            }
            itemPreco*=item.getQuantidade();
            total+=itemPreco;
        }
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        boolean duplicated = false;
        for(ItemPedido item :itens){
            if(item.getShake().equals(itemPedidoAdicionado.getShake())){
                item.setQuantidade(item.getQuantidade()+itemPedidoAdicionado.getQuantidade());
                duplicated = true;
            }
        }
        if(!duplicated) itens.add(itemPedidoAdicionado);
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        if (itens.stream().anyMatch(item -> item.getShake().toString().equals(itemPedidoRemovido.getShake().toString()))) {//TODO: Certo o uso do toString?
            for(ItemPedido item : itens){
                if(item.getShake().toString().equals(itemPedidoRemovido.getShake().toString())){
                    if((item.getQuantidade()-1)==0){
                        itens.remove(item);
                    } else item.setQuantidade(item.getQuantidade()-1);
                    break;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
