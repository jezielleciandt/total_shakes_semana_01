package demo;

import ingredientes.base.Base;
import ingredientes.base.TipoBase;
import ingredientes.fruta.Fruta;
import ingredientes.fruta.TipoFruta;
import ingredientes.topping.TipoTopping;
import ingredientes.topping.Topping;
import pedido.Cardapio;
import pedido.Cliente;
import pedido.ItemPedido;
import pedido.Pedido;
import produto.Shake;
import produto.TipoTamanho;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1,"Pedro","pedro@email.com");
        Cardapio cardapio = new Cardapio();

        Base sorvete = new Base(TipoBase.SORVETE);
        Base iogurte = new Base(TipoBase.IOGURTE);
        Fruta banana = new Fruta(TipoFruta.BANANA);
        Fruta morango = new Fruta(TipoFruta.MORANGO);
        Topping mel = new Topping(TipoTopping.MEL);
        Topping aveia = new Topping(TipoTopping.AVEIA);

        cardapio.adicionarIngrediente(sorvete,10.0);
        cardapio.adicionarIngrediente(iogurte,8.0);
        cardapio.adicionarIngrediente(banana,5.0);
        cardapio.adicionarIngrediente(morango,7.5);
        cardapio.adicionarIngrediente(mel,1.0);
        cardapio.adicionarIngrediente(aveia, 3.0);

        Shake shake1 = new Shake(sorvete,banana,mel, TipoTamanho.P);

        ItemPedido itemPedido1 = new ItemPedido(shake1,1);
        Pedido pedido1 = new Pedido(1, new ArrayList<>(List.of(itemPedido1)),cliente);

        System.out.println("::::: Cardapio ShakeCIT");
        System.out.println(cardapio.getPrecos());

        System.out.println("::::: Criando um Shake Básico 1:1:1:0");
        System.out.println(pedido1);
        System.out.println(pedido1.calcularTotal(cardapio));

        System.out.println("::::: Serializando Cliente 1 e Desserializando Pedido 1");
        cliente.serializarPedido(pedido1);
        Pedido pedidoDesserializado = cliente.desserializarPedido(pedido1.getId());

        System.out.println(pedidoDesserializado);
        System.out.println(pedidoDesserializado.equals(pedido1));
    }
}
