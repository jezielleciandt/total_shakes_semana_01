package br.com.TDD.produto;

import br.com.TDD.ingredientes.Adicional;
import br.com.TDD.ingredientes.Base;
import br.com.TDD.ingredientes.Fruta;
import br.com.TDD.ingredientes.Topping;

import java.util.List;
import java.util.stream.Collectors;

public class Shake {
    private final Base base;
    private final Fruta fruta;
    private final Topping topping;
    private List<Adicional> adicionais;
    private final TipoTamanho  tipoTamanho;

    public Shake(Base base, Fruta fruta, Topping topping, List<Adicional> adicionais, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.adicionais = adicionais.stream().sorted().collect(Collectors.toList());
        this.tipoTamanho = tipoTamanho;
    }

    public Shake(Base base,Fruta fruta, Topping topping, TipoTamanho  tipoTamanho){
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
        return adicionais;
    }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    @Override
    public String toString() {
        return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / " + this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }
}
