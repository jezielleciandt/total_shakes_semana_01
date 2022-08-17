package ingredientes;

import java.io.Serializable;

public class Topping implements Adicional,Comparable<Ingrediente>, Serializable {
    private static final long serialVersionUID = 1L;
    private TipoTopping tipoTopping;

    public Topping(TipoTopping tipoTopping) {
        this.tipoTopping = tipoTopping;
    }

    public TipoTopping getTipoTopping(){
        return this.tipoTopping;
    }

    @Override
    public int compareTo(Ingrediente ingrediente) {
        return this.obterTipo().toString().compareTo(ingrediente.obterTipo().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topping)) return false;

        Topping topping = (Topping) o;

        return tipoTopping == topping.tipoTopping;
    }

    @Override
    public int hashCode() {
        return tipoTopping.hashCode();
    }

    @Override
    public String toString() {
        return this.tipoTopping.toString();
    }

    @Override
    public Enum obterTipo() {
        return this.tipoTopping;
    }
}