package pedido;

import ingredientes.Adicional;
import ingredientes.Ingrediente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Pedido {

    private final int id;
    private final ArrayList<ItemPedido> itens;
    private final Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens, Cliente cliente) {
        this.id = id;
        this.itens = itens;
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio) {
        Double total = (double) 0;
        for (ItemPedido itemPedido : this.itens) {
            Double totalItem = (double) 0;
            for (Map.Entry<Ingrediente, Double> precoIngrediente : cardapio.getPrecos().entrySet()) {
                if (itemPedido.getShake().getBase().compareTo(precoIngrediente.getKey()) == 0) {
                    totalItem += precoIngrediente.getValue();
                }
            }
            totalItem = totalItem * itemPedido.getShake().getTipoTamanho().multiplicador;
            for (Map.Entry<Ingrediente, Double> precoIngrediente : cardapio.getPrecos().entrySet()) {
                for (Adicional adicional : itemPedido.getShake().getAdicionais()) {
                    if (adicional.equals(precoIngrediente.getKey())) {
                        totalItem += precoIngrediente.getValue();
                    }
                }
            }
            totalItem = totalItem * itemPedido.getQuantidade();
            total += totalItem;
        }
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado) {
        sortAdicionais(itemPedidoAdicionado);
        boolean added = false;
        for (ItemPedido item : itens) {
            if (!added) {
                if (item.getShake().equals(itemPedidoAdicionado.getShake())) {
                    item.setQuantidade(item.getQuantidade() + itemPedidoAdicionado.getQuantidade());
                    added = true;
                }
            }
        }

        if (!added) {
            itens.add(itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        sortAdicionais(itemPedidoRemovido);
        ItemPedido itemToRemove = null;
        boolean removed = false;
        for (ItemPedido item : itens) {
            if (!removed) {
                if (item.getShake().equals(itemPedidoRemovido.getShake())) {
                    if (item.getQuantidade() == 1) {
                        itemToRemove = item;
                        removed = true;
                    } else {
                        item.setQuantidade(item.getQuantidade() - 1);
                        removed = true;
                    }
                }
            }
        }
        if (itemToRemove != null)
            itens.remove(itemToRemove);
        if (!removed)
            throw new IllegalArgumentException("Item nao existe no pedido.");
        return false;
    }

    public void sortAdicionais(ItemPedido pedido) {
        if (pedido.getShake().getAdicionais() != null) {
            if (pedido.getShake().getAdicionais().size() > 0) {
                pedido.getShake().getAdicionais().sort(new Comparator<Ingrediente>() {
                    @Override
                    public int compare(Ingrediente o1, Ingrediente o2) {
                        return o1.obterTipo().toString().compareTo(o2.obterTipo().toString());
                    }
                });
            }
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
