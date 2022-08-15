package ingredientes.base;
import ingredientes.Ingrediente;

public class Base implements Ingrediente,Comparable<Ingrediente>{

    private static final long serialVersionUID = 2L;

    private final TipoBase tipoBase;

    public Base(TipoBase tipoBase) {
        this.tipoBase = tipoBase;
    }

    @Override
    public TipoBase obterTipo() {
        return this.tipoBase;
    }

    @Override
    public int compareTo(Ingrediente ingrediente) {
        return this.obterTipo().toString().compareToIgnoreCase(ingrediente.obterTipo().toString());
    }

    @Override
    public String toString() {
        return this.tipoBase.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;

        Base base = (Base) o;

        return tipoBase == base.tipoBase;
    }

    @Override
    public int hashCode() {
        return tipoBase.hashCode();
    }
}
