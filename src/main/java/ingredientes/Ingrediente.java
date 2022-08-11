package ingredientes;

import java.io.Serializable;

public interface Ingrediente extends Serializable {
    Enum<?> obterTipo();
}