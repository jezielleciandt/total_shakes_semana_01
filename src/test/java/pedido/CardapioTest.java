package pedido;

import ingredientes.*;
import ingredientes.base.Base;
import ingredientes.base.TipoBase;
import ingredientes.fruta.Fruta;
import ingredientes.fruta.TipoFruta;
import ingredientes.topping.TipoTopping;
import ingredientes.topping.Topping;
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
        Base base = new Base(TipoBase.IOGURTE);
        Fruta fruta = new Fruta(TipoFruta.MORANGO);
        Topping topping = new Topping(TipoTopping.MEL);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        assertEquals(3, cardapio.getPrecos().size());

        for (Map.Entry<Ingrediente,Double> pair : cardapio.getPrecos().entrySet()) {
            if (contator == 0) {
                assertEquals(new Base(TipoBase.IOGURTE), pair.getKey());
                assertEquals(1.0, pair.getValue());
            }
            if (contator == 1) {
                assertEquals(new Topping(TipoTopping.MEL), pair.getKey());
                assertEquals(10.0, pair.getValue());
            }
            if (contator == 2) {
                assertEquals(new Fruta(TipoFruta.MORANGO), pair.getKey());
                assertEquals(5.0, pair.getValue());
            }
            contator += 1;
        }
    }

    @Test
    void test_adicionar_ingredientes_exception_precoInvalido(){
        Base base = new Base(TipoBase.IOGURTE);
        Fruta fruta = new Fruta(TipoFruta.MORANGO);

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
        Base base = new Base(TipoBase.IOGURTE);
        Fruta fruta = new Fruta(TipoFruta.MORANGO);
        Topping topping = new Topping(TipoTopping.MEL);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        cardapio.atualizarIngrediente(new Base(TipoBase.IOGURTE), 9.0);

        assertEquals(3, cardapio.getPrecos().size());
        assertEquals(9.0, cardapio.getPrecos().get(new Base(TipoBase.IOGURTE)));
        assertEquals(5.0, cardapio.getPrecos().get(new Fruta(TipoFruta.MORANGO)));
        assertEquals(10.0, cardapio.getPrecos().get(new Topping(TipoTopping.MEL)));
    }

    @Test
    void test_atualizar_ingredientes_exception_precoInvalido(){
        Base base = new Base(TipoBase.IOGURTE);
        Fruta fruta = new Fruta(TipoFruta.MORANGO);

        cardapio.adicionarIngrediente(base, 9.0);
        cardapio.adicionarIngrediente(fruta, 10.0);

        try {
            cardapio.atualizarIngrediente(new Base(TipoBase.IOGURTE), -9.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Preco invalido.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            cardapio.atualizarIngrediente(new Fruta(TipoFruta.MORANGO), 0.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Preco invalido.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_atualizar_ingredientes_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.IOGURTE);
        Fruta fruta = new Fruta(TipoFruta.MORANGO);
        Topping topping = new Topping(TipoTopping.AVEIA);

        cardapio.adicionarIngrediente(base, 9.0);
        cardapio.adicionarIngrediente(fruta, 10.0);
        cardapio.adicionarIngrediente(fruta, 10.0);

        try {
            cardapio.atualizarIngrediente(new Topping(TipoTopping.MEL), 19.0);
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Ingrediente nao existe no cardapio.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_remover_ingredientes_properly(){
        int contator = 0;
        Base base = new Base(TipoBase.IOGURTE);
        Fruta fruta = new Fruta(TipoFruta.MORANGO);
        Topping topping = new Topping(TipoTopping.MEL);

        cardapio.adicionarIngrediente(base, 1.0);
        cardapio.adicionarIngrediente(fruta, 5.0);
        cardapio.adicionarIngrediente(topping, 10.0);

        cardapio.removerIngrediente(new Base(TipoBase.IOGURTE));

        assertEquals(2, cardapio.getPrecos().size());

        for (Map.Entry<Ingrediente,Double> pair : cardapio.getPrecos().entrySet()) {
            if (contator == 0) {
                assertEquals(new Topping(TipoTopping.MEL), pair.getKey());
                assertEquals(10.0, pair.getValue());
            }
            if (contator == 1) {
                assertEquals(new Fruta(TipoFruta.MORANGO), pair.getKey());
                assertEquals(5.0, pair.getValue());
            }
            contator += 1;
        }
    }

    @Test
    void test_remover_ingredientes_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.IOGURTE);

        cardapio.adicionarIngrediente(base, 1.0);

        try {
            cardapio.removerIngrediente(new Topping(TipoTopping.MEL));
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Ingrediente nao existe no cardapio.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void test_buscar_ingrediente_properly(){
        Base base = new Base(TipoBase.IOGURTE);

        cardapio.adicionarIngrediente(base, 1.0);

        assertEquals(1.0, cardapio.buscarPreco(new Base(TipoBase.IOGURTE)));
    }

    @Test
    void test_buscar_ingrediente_exception_ingredienteInexistente(){
        Base base = new Base(TipoBase.IOGURTE);

        cardapio.adicionarIngrediente(base, 1.0);

        try {
            cardapio.buscarPreco(new Base(TipoBase.SORVETE));
            fail("Excecao nao encontrada");
        } catch (Throwable e) {
            assertEquals("Ingrediente nao existe no cardapio.", e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

}