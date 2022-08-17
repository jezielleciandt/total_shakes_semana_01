package ingredientes;

import java.io.Serializable;

public class Base implements Ingrediente,Comparable<Ingrediente>, Serializable {
    private static final long serialVersionUID = 1L;

    private TipoBase tipoBase;

    public Base(TipoBase tipoBase) {
        this.tipoBase = tipoBase;
    }

    public TipoBase getTipoBase(){
        return this.tipoBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;

        Base base = (Base) o;

        return tipoBase == base.tipoBase;
    }

    @Override
    public int compareTo(Ingrediente ingrediente) {
        return this.tipoBase.toString().compareTo(ingrediente.obterTipo().toString());
    }

    @Override
    public int hashCode() {
        return tipoBase.hashCode();
    }

    @Override
    public String toString() {
        return this.tipoBase.toString();
    }

    @Override
    public Enum obterTipo() {
        return this.tipoBase;
    }
}