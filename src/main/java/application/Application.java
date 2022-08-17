package application;

import pedido.Pedido;
import java.time.LocalDate;
import java.util.Iterator;

public interface Application {
    Iterator<Pedido> getPedidos();

    Pedido addPedido();

    void serializarPedidos();

    Iterator<Pedido> desserializarPedidos(LocalDate localDateOfSerialization, int minuteOfSerialization);
}