package pedido;

import br.com.TDD.armazem.Armazem;
import br.com.TDD.ingredientes.Base;
import br.com.TDD.ingredientes.Ingrediente;
import br.com.TDD.ingredientes.TipoBase;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArmazemTest {

    Ingrediente ingrediente = new Base(TipoBase.Sorvete);
    Armazem armazem = new Armazem();

    @Test
    @Order(1)
    public void esperaCadastrarIngredientesEmEstoque_Successfully() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);

        Boolean isPresent = armazem.getEstoque().containsKey(ingrediente);

        assertEquals(true, isPresent);
    }

    @Test
    @Order(2)
    public void esperaNaoCadastrarIngredienteDuplicado_Exception() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> armazem.cadastrarIngredientesEmEstoque(ingrediente));

        assertEquals("Ingrediente já cadastrado.", exception.getMessage());
    }

    @Test
    @Order(3)
    public void esperaDescartarIngredienteEmEstoque_Successfully() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);
        armazem.descartarIngredienteEmEstoque(ingrediente);
        Boolean isNotPresent = armazem.getEstoque().containsKey(ingrediente);

        assertEquals(false, isNotPresent);
    }

    @Test
    @Order(4)
    public void esperaNaoDescartarIngredienteNaoEcontrado_Exception() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> armazem.descartarIngredienteEmEstoque(ingrediente));

        assertEquals("Ingrediente não encontrado.", exception.getMessage());
    }

    @Test
    @Order(5)
    public void esperaAdicionarQuantidadeDoIngredienteNoEstoque_Successfully() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, 5);
        Integer quantidade = armazem.getEstoque().get(ingrediente).intValue();

        assertEquals(5, quantidade);
    }


    @Test
    @Order(6)
    public void esperaNaoAdicionarQuantidadeComValorInvalido_Exception() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, 0));

        assertEquals("Quantidade inválida.", exception.getMessage());
    }

    @Test
    @Order(7)
    public void esperaNaoAdicionarQuantidadeComIngredienteNaoEncontrado_Exception() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, 3));

        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Ingrediente não encontrado.", exception.getMessage());
    }

    @Test
    @Order(8)
    public void esperaReduzirQuantidadeDoIngredienteNoEstoque_Successfully() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, 5);
        armazem.reduzirQuantidadeDoIngredienteEmEstoque(ingrediente, 1);
        Integer quantidade = armazem.getEstoque().get(ingrediente).intValue();

        assertEquals(4, quantidade);
    }

    @Test
    @Order(9)
    public void esperaNaoReduzirQuantidadeComValorInvalido_Exception() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(ingrediente, -1));

        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Quantidade inválida.", exception.getMessage());
    }

    @Test
    @Order(10)
    public void esperaNaoReduzirQuantidadeComIngredienteNaoEncontrado_Exception() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(ingrediente, 3));

        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Ingrediente não encontrado.", exception.getMessage());
    }

    @Test
    @Order(11)
    public void esperaConsultarQuantidadeDoIngredienteEmEstoque_Successfully() {

        armazem.cadastrarIngredientesEmEstoque(ingrediente);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(ingrediente, 5);
        Integer quantidade = armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente);

        assertEquals(5, quantidade);
    }

    @Test
    @Order(12)
    public void esperaNaoConsultarQuantidadeComIngredienteNaoEncontrado_Exception() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> armazem.consultarQuantidadeDoIngredienteEmEstoque(ingrediente));

        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Ingrediente não encontrado.", exception.getMessage());
    }
}