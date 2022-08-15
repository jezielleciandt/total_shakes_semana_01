package pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int id;
    private final ArrayList<ItemPedido> itens;
    private final Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        double total= 0;

        for (ItemPedido item: itens) {
            var shake = item.getShake();
            var qtdShake = item.getQuantidade();
            var adicionais = shake.getAdicionais();

            var precoBase = cardapio.getPrecos().get(shake.getBase());
            var precoComQuantidade = precoBase + (precoBase * shake.getTipoTamanho().multiplicador);
            var totalAdicionais = adicionais.stream()
                    .map(adicional -> cardapio.getPrecos().get(adicional))
                    .reduce(Double::sum).orElse(0.0);

            total += (precoComQuantidade + totalAdicionais) *  qtdShake;
        }

        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){

        Optional<ItemPedido> optionalItemPedido = itens.stream()
                .filter(itemPedido -> itemPedido.getShake().equals(itemPedidoAdicionado.getShake()))
                .findAny();

        optionalItemPedido.ifPresentOrElse( itemPedido -> {
            var itemPedidoAtualizado = new ItemPedido(itemPedido.getShake(), itemPedido.getQuantidade());

            int quantidadeAtualizada = itemPedido.getQuantidade() + itemPedidoAdicionado.getQuantidade();
            itemPedidoAtualizado.setQuantidade(quantidadeAtualizada);

            itens.remove(itemPedido);
            itens.add(itemPedidoAtualizado);

        },() -> itens.add(itemPedidoAdicionado));
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {

        ItemPedido itemPedidoExistente = itens.stream()
                .filter(itemPedido ->
                        itemPedido.equals(itemPedidoRemovido))
                .findAny().orElseThrow(() -> new IllegalArgumentException("Item nao existe no pedido."));

        var itemPedidoAtualizado = new ItemPedido(itemPedidoExistente.getShake(), itemPedidoExistente.getQuantidade());
        itemPedidoAtualizado.setQuantidade(itemPedidoExistente.getQuantidade() - 1);

        if(itemPedidoAtualizado.getQuantidade() == 0){
            return this.itens.remove(itemPedidoExistente);
        }

        this.itens.remove(itemPedidoExistente);
        return this.itens.add(itemPedidoAtualizado);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id && itens.equals(pedido.itens) && cliente.equals(pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itens, cliente);
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
