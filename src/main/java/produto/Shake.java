package produto;

import ingredientes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shake {
    private Base base;
    private Fruta fruta;
    private Topping topping;
    private TipoTamanho  tipoTamanho;
    private List<Adicional> adicionais;

    public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.tipoTamanho = tipoTamanho;
        this.adicionais = new ArrayList<>();
    }

    public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho, List<Adicional> adicionais) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.tipoTamanho = tipoTamanho;
        this.adicionais = adicionais.stream().sorted().collect(Collectors.toList());
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

    public List<Adicional> getAdicionais() { return adicionais; }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    @Override
    public String toString() {
        return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / " + this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }
}
