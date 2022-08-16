package produto;

public enum TipoTamanho {
    P(1),
    M(1.3),
    G(1.5);
    public final double multiplicador;
    public double getMultiplicador() {
        return multiplicador;
    }

    TipoTamanho(double multiplicador) {
        this.multiplicador = multiplicador;
    }


}
