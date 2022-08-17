package br.com.TDD.pedido;

import java.util.ArrayList;
import java.util.Optional;

public class Pedido{

    private final int id;
    private final ArrayList<ItemPedido> itens;
    private final Cliente cliente;

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
        for(ItemPedido  pItem : itens){
            var shake = pItem.getShake();
            var quantShake = pItem.getQuantidade();
            var base = shake.getBase();
            var adicionais = shake.getAdicionais();

            var precoBase = cardapio.getPrecos().get(base);
            var precoTamanho = precoBase + (precoBase * shake.getTipoTamanho().multiplicador);
            var precoAdicionais = adicionais.stream().map(adicional -> cardapio.getPrecos().get(adicional)).reduce(0.0, Double::sum);

            total += (precoTamanho + precoAdicionais) * quantShake;
        }
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        Optional<ItemPedido> itemPedido = itens.stream().filter(shake ->
                shake.getShake().equals(itemPedidoAdicionado.getShake())).findFirst();
        if(itemPedido.isEmpty() == false) {
            itemPedidoAdicionado.setQuantidade(itemPedidoAdicionado.getQuantidade() + itemPedido.get().getQuantidade());
        } else {
            itens.add(itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {

        if (itens != null) {
            Optional<ItemPedido> itemPedido = itens.stream().filter(item -> item.getShake().equals(itemPedidoRemovido.getShake())).findAny();
            if (itemPedido.isPresent()) {
                itemPedidoRemovido.setQuantidade(itemPedido.get().getQuantidade() - 1);
                if (itemPedidoRemovido.getQuantidade() == 0) {
                    itens.remove(itemPedidoRemovido);
                }
            }
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
        return true;
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
