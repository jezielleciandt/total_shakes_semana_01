package br.com.TDD.produto;

public enum TipoTamanho {
    P(1), M(1.3), G(1.5);

    public double getMultiplicador(){
        return multiplicador;
    }

    TipoTamanho(double multiplicador){
        this.multiplicador = multiplicador;
    }

    public final double multiplicador;

}
