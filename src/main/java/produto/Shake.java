package produto;

import ingredientes.Adicional;
import ingredientes.Base;
import ingredientes.Fruta;
import ingredientes.Topping;

import java.util.ArrayList;
import java.util.List;

public class Shake {
    private Base base;
    private Fruta fruta;
    private Topping topping;
    private List<Adicional> adicionais = new ArrayList<>();
    private TipoTamanho tipoTamanho;

    public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.tipoTamanho = tipoTamanho;
    }

    public Shake(Base base, Fruta fruta, Topping topping, List<Adicional> adicionais, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.adicionais = adicionais;
        this.tipoTamanho = tipoTamanho;
    }

    public Base getBase() {
        return base;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public Topping getTopping() {
        return topping;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    @Override
    public String toString() {
        return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / " + this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Shake)) {
            return false;
        }

        Shake c = (Shake) o;

        if (c.getBase().toString().equals(this.getBase().toString())
                && c.getFruta().toString().equals(this.getFruta().toString())
                && c.getTopping().toString().equals(this.getTopping().toString())
                && c.getTipoTamanho().toString().equals(this.getTipoTamanho().toString())) {
            ArrayList<Adicional> cp = new ArrayList<>(this.getAdicionais());
            for (Adicional ad : c.getAdicionais()) {
                if (!cp.remove(ad)) {
                    return false;
                }
            }
            return cp.isEmpty();
        }
        return false;
    }
}
