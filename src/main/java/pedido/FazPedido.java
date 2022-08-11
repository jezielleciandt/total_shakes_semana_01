package pedido;

public interface FazPedido {

    void serializarPedido(Pedido pedido);

    Pedido desserializarPedido(int id);
}
