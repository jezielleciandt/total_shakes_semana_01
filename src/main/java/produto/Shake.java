package produto;

import ingredientes.*;
import ingredientes.base.Base;
import ingredientes.fruta.Fruta;
import ingredientes.topping.Topping;

import java.io.Serializable;
import java.util.*;

public class Shake implements Serializable {

    private final Base base;
    private final Fruta fruta;
    private final Topping topping;
    private List<Adicional> adicionais = new ArrayList<>();
    private final TipoTamanho  tipoTamanho;

    public Shake(Base base, Fruta fruta, Topping topping, List<Adicional> adicionais, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.adicionais = ordenarAntesDeAtribuir(adicionais);
        this.tipoTamanho = tipoTamanho;
    }

    public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
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
        adicionais.sort(((adicional, adicional2) -> adicional.obterTipo().toString()
                .compareToIgnoreCase(adicional2.obterTipo().toString())));
        return adicionais;
    }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    private List<Adicional> ordenarAntesDeAtribuir(List<Adicional> adicionais) {
        adicionais.sort(Comparator.comparing(adicional -> adicional.obterTipo().toString()));
        return adicionais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shake shake = (Shake) o;
        return base.equals(shake.base) && fruta.equals(shake.fruta) && topping.equals(shake.topping)
                && Objects.equals(adicionais, shake.adicionais) && tipoTamanho == shake.tipoTamanho;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, fruta, topping, adicionais, tipoTamanho);
    }

    @Override
    public String toString() {
        return this.base.obterTipo().toString() + " / "
                + this.fruta.obterTipo().toString()
                + " / " + this.topping.obterTipo().toString()
                + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }
}
