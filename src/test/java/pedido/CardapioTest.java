package pedido;

import ingredientes.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardapioTest {

    Cardapio cardapio;

    @BeforeAll
    void setup(){
        cardapio = new Cardapio();
    }

    @Test
    void test_adicionar_ingredientes_properly(){
        int contator = 0;
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Mel);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        assertEquals(3, cardapio.getPrecos().size());

        for (Map.Entry<Ingrediente,Double> pair : cardapio.getPrecos().entrySet()) {
            if (contator == 0) {
                assertEquals(new Base(TipoBase.Iorgute), pair.getKey());
                assertEquals(1.0, pair.getValue());
            }
            if (contator == 1) {
                assertEquals(new Topping(TipoTopping.Mel), pair.getKey());
                assertEquals(10.0, pair.getValue());
            }
            if (contator == 2) {
                assertEquals(new Fruta(TipoFruta.Morango), pair.getKey());
                assertEquals(5.0, pair.getValue());
            }
            contator += 1;
        }
    }

    @Test
    void test_adicionar_ingredientes_exception_precoInvalido(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);

        try {
            cardapio.adicionarIngrediente(base, -9.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Preco invalido.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            cardapio.adicionarIngrediente(fruta, 0.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Preco invalido.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_atualizar_ingredientes_properly(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Mel);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        cardapio.atualizarIngrediente(new Base(TipoBase.Iorgute), 9.0);

        assertEquals(3, cardapio.getPrecos().size());
        assertEquals(9.0, cardapio.getPrecos().get(new Base(TipoBase.Iorgute)));
        assertEquals(5.0, cardapio.getPrecos().get(new Fruta(TipoFruta.Morango)));
        assertEquals(10.0, cardapio.getPrecos().get(new Topping(TipoTopping.Mel)));
    }

    @Test
    void test_atualizar_ingredientes_exception_precoInvalido(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);

        cardapio.adicionarIngrediente(base, 9.0);
        cardapio.adicionarIngrediente(fruta, 10.0);

        try {
            cardapio.atualizarIngrediente(new Base(TipoBase.Iorgute), -9.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Preco invalido.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            cardapio.atualizarIngrediente(new Fruta(TipoFruta.Morango), 0.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Preco invalido.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_atualizar_ingredientes_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Aveia);

        cardapio.adicionarIngrediente(base, 9.0);
        cardapio.adicionarIngrediente(fruta, 10.0);
        cardapio.adicionarIngrediente(fruta, 10.0);

        try {
            cardapio.atualizarIngrediente(new Topping(TipoTopping.Mel), 19.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Ingrediente nao existe no cardapio.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_remover_ingredientes_properly(){
        int contator = 0;
        Base base = new Base(TipoBase.Iorgute);
        Fruta fruta = new Fruta(TipoFruta.Morango);
        Topping topping = new Topping(TipoTopping.Mel);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        cardapio.removerIngrediente(new Base(TipoBase.Iorgute));

        assertEquals(2, cardapio.getPrecos().size());

        for (Map.Entry<Ingrediente,Double> pair : cardapio.getPrecos().entrySet()) {
            if (contator == 0) {
                assertEquals(new Topping(TipoTopping.Mel), pair.getKey());
                assertEquals(10.0, pair.getValue());
            }
            if (contator == 1) {
                assertEquals(new Fruta(TipoFruta.Morango), pair.getKey());
                assertEquals(5.0, pair.getValue());
            }
            contator += 1;
        }
    }

    @Test
    void test_remover_ingredientes_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.Iorgute);

        cardapio.adicionarIngrediente(base, 1.0);

        try {
            cardapio.removerIngrediente(new Topping(TipoTopping.Mel));
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Ingrediente nao existe no cardapio.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_buscar_ingrediente_properly(){
        Base base = new Base(TipoBase.Iorgute);

        cardapio.adicionarIngrediente(base, 1.0);

        assertEquals(1.0, cardapio.buscarPreco(new Base(TipoBase.Iorgute)));
    }

    @Test
    void test_buscar_ingrediente_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.Iorgute);

        cardapio.adicionarIngrediente(base, 1.0);

        try {
            cardapio.buscarPreco(new Base(TipoBase.Sorvete));
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Ingrediente nao existe no cardapio.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

}