package pedido;

import ingredientes.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import produto.Shake;
import produto.TipoTamanho;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PedidoTest{

    Pedido pedido;
    Cardapio cardapio;

    @BeforeAll
    void setup(){
        cardapio = new Cardapio();
        cardapio.adicionarIngrediente(new Base(TipoBase.Iorgute), 10.0);
        cardapio.adicionarIngrediente(new Base(TipoBase.Sorvete), 5.0);
        cardapio.adicionarIngrediente(new Fruta(TipoFruta.Banana), 1.0);
        cardapio.adicionarIngrediente(new Fruta(TipoFruta.Morango), 10.0);
        cardapio.adicionarIngrediente(new Topping(TipoTopping.Aveia), 2.0);
        cardapio.adicionarIngrediente(new Topping(TipoTopping.Mel), 1.0);
        cardapio.adicionarIngrediente(new Topping(TipoTopping.Chocolate), 100.0);
    }

    @BeforeEach
    void resetPedido(){
        pedido = new Pedido(1, new ArrayList<>(), new Cliente(
                1,
                "Cliente Test",
                "cliente.test@email.com"
        ));
    }

    @Test
    void test_adicionarItemPedido_properly(){
        Shake shake = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Fruta(TipoFruta.Banana), new Topping(TipoTopping.Aveia))),
                TipoTamanho.P
        );

        ItemPedido itemPedido = new ItemPedido(shake, 1);

        pedido.adicionarItemPedido(itemPedido);

        assertEquals(1, pedido.getItens().size());
        pedido.getItens().forEach(item -> {
            assertEquals(new Base(TipoBase.Sorvete), item.getShake().getBase());
            assertEquals(new Fruta(TipoFruta.Morango), item.getShake().getFruta());
            assertEquals(new Topping(TipoTopping.Mel), item.getShake().getTopping());
            assertEquals(2, item.getShake().getAdicionais().size());
            assertEquals(new Topping(TipoTopping.Aveia), item.getShake().getAdicionais().get(0));
            assertEquals(new Fruta(TipoFruta.Banana), item.getShake().getAdicionais().get(1));
            assertEquals(TipoTamanho.P, item.getShake().getTipoTamanho());
            assertEquals(1, item.getQuantidade());
        });
    }

    @Test
    void test_adicionarItemPedido_itemPedidoDuplicado(){
        Shake shake = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                TipoTamanho.P
        );

        ItemPedido itemPedido = new ItemPedido(shake, 1);
        ItemPedido itemPedido2 = new ItemPedido(shake, 2);

        pedido.adicionarItemPedido(itemPedido);
        pedido.adicionarItemPedido(itemPedido2);

        assertEquals(1, pedido.getItens().size());
        pedido.getItens().forEach(item -> {
            assertEquals(new Base(TipoBase.Sorvete), item.getShake().getBase());
            assertEquals(new Fruta(TipoFruta.Morango), item.getShake().getFruta());
            assertEquals(new Topping(TipoTopping.Mel), item.getShake().getTopping());
            assertEquals(new ArrayList<>(), item.getShake().getAdicionais());
            assertEquals(TipoTamanho.P, item.getShake().getTipoTamanho());
            assertEquals(3, item.getQuantidade());
        });
    }

    @Test
    void test_adicionarItemPedido_itemPedidoDiferentes(){
        Shake shake = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Fruta(TipoFruta.Banana), new Topping(TipoTopping.Aveia))),
                TipoTamanho.P
        );

        Shake shake2 = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Fruta(TipoFruta.Banana), new Topping(TipoTopping.Mel))),
                TipoTamanho.P
        );

        ItemPedido itemPedido = new ItemPedido(shake, 1);
        ItemPedido itemPedido2 = new ItemPedido(shake2, 2);

        pedido.adicionarItemPedido(itemPedido);
        pedido.adicionarItemPedido(itemPedido2);

        assertEquals(2, pedido.getItens().size());
        assertEquals(itemPedido, pedido.getItens().get(0));
        assertEquals(itemPedido2, pedido.getItens().get(1));
    }

    @Test
    void test_removerItemPedido_properly(){
        Shake shake = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Fruta(TipoFruta.Banana), new Topping(TipoTopping.Aveia))),
                TipoTamanho.P
        );

        ItemPedido itemPedido = new ItemPedido(shake, 1);

        pedido.adicionarItemPedido(itemPedido);
        pedido.removeItemPedido(itemPedido);

        assertEquals(0, pedido.getItens().size());
    }

    @Test
    void test_removerItemPedido_quantidadeMaiorQue1(){
        Shake shake = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Fruta(TipoFruta.Banana), new Topping(TipoTopping.Aveia))),
                TipoTamanho.P
        );

        Shake shakeRemovido = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Topping(TipoTopping.Aveia), new Fruta(TipoFruta.Banana))),
                TipoTamanho.P
        );

        ItemPedido itemPedido = new ItemPedido(shake, 3);
        ItemPedido itemPedidoRemovido = new ItemPedido(shakeRemovido, 10);

        pedido.adicionarItemPedido(itemPedido);
        pedido.removeItemPedido(itemPedidoRemovido);

        assertEquals(1, pedido.getItens().size());
        assertEquals(2, pedido.getItens().get(0).getQuantidade());
    }

    @Test
    void test_removerItemPedido_quantidadeIgualA1(){
        Shake shake = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Fruta(TipoFruta.Banana), new Topping(TipoTopping.Aveia))),
                TipoTamanho.P
        );

        Shake shakeRemovido = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Topping(TipoTopping.Aveia), new Fruta(TipoFruta.Banana))),
                TipoTamanho.P
        );

        ItemPedido itemPedido = new ItemPedido(shake, 1);
        ItemPedido itemPedidoRemovido = new ItemPedido(shakeRemovido, 10);

        pedido.adicionarItemPedido(itemPedido);
        pedido.removeItemPedido(itemPedidoRemovido);

        assertEquals(0, pedido.getItens().size());
    }

    @Test
    void test_removerItemPedido_exception_itemNaoExiste(){
        Shake shake = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Fruta(TipoFruta.Banana), new Topping(TipoTopping.Aveia))),
                TipoTamanho.P
        );

        Shake shakeRemovido = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Aveia),
                new ArrayList<>(List.of(new Topping(TipoTopping.Aveia), new Fruta(TipoFruta.Banana))),
                TipoTamanho.P
        );

        ItemPedido itemPedido = new ItemPedido(shake, 1);
        ItemPedido itemPedidoRemovido = new ItemPedido(shakeRemovido, 10);

        pedido.adicionarItemPedido(itemPedido);

        try{
            pedido.removeItemPedido(itemPedidoRemovido);
            fail("Excecao nao encontrada.");
        }catch(Throwable e){
            assertEquals("Item nao existe no pedido.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_calcularPedido_comAdicional_properly(){
        Shake shake1 = new Shake(new Base(TipoBase.Iorgute),
                new Fruta(TipoFruta.Banana),
                new Topping(TipoTopping.Aveia),
                new ArrayList<>(List.of(new Topping(TipoTopping.Mel))),
                TipoTamanho.G); //16

        Shake shake2 = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(List.of(new Topping(TipoTopping.Chocolate))),
                TipoTamanho.M); // 106.5

        ItemPedido itemPedido1 = new ItemPedido(shake1, 1);
        ItemPedido itemPedido2 = new ItemPedido(shake2, 2);

        pedido.adicionarItemPedido(itemPedido1);
        pedido.adicionarItemPedido(itemPedido2);

        assertEquals(229, pedido.calcularTotal(cardapio));
    }

    @Test
    void test_calcularPedido_semAdicional_properly(){
        Shake shake1 = new Shake(new Base(TipoBase.Iorgute),
                new Fruta(TipoFruta.Banana),
                new Topping(TipoTopping.Aveia),
                new ArrayList<>(),
                TipoTamanho.G); //15

        Shake shake2 = new Shake(new Base(TipoBase.Sorvete),
                new Fruta(TipoFruta.Morango),
                new Topping(TipoTopping.Mel),
                new ArrayList<>(),
                TipoTamanho.P); // 5

        ItemPedido itemPedido1 = new ItemPedido(shake1, 1);
        ItemPedido itemPedido2 = new ItemPedido(shake2, 2);

        pedido.adicionarItemPedido(itemPedido1);
        pedido.adicionarItemPedido(itemPedido2);

        assertEquals(25, pedido.calcularTotal(cardapio));
    }

}