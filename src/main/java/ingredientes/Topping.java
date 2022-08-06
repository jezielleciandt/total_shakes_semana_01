package ingredientes;

public class Topping implements Adicional,Comparable<Ingrediente> {
    private TipoTopping tipoTopping;

    public Topping(TipoTopping tipoTopping) {
        this.tipoTopping = tipoTopping;
    }

    public TipoTopping getTipoTopping(){
        return this.tipoTopping;
    }


    //É necessário consertar o compareTo, para imprimir na ordem correta.
    @Override
    public int compareTo(Ingrediente ingrediente) {
        return ingrediente.obterTipo().toString().compareTo(this.obterTipo().toString());
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
