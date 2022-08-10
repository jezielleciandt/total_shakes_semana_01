package ingredientes.base;

import ingredientes.Ingrediente;

public class Base implements Ingrediente,Comparable<Ingrediente>{

    private final TipoBase tipoBase;

    public Base(TipoBase tipoBase) {
        this.tipoBase = tipoBase;
    }

    public TipoBase getTipoBase(){
        return this.tipoBase;
    }

    @Override
    public TipoBase obterTipo() {
        return this.tipoBase;
    }

    //É necessário consertar o compareTo, para imprimir na ordem correta.
    @Override
    public int compareTo(Ingrediente ingrediente) {
        return ingrediente.obterTipo().toString().compareToIgnoreCase(this.obterTipo().toString());
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
