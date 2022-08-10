package produto;

public enum TipoTamanho {

    P(0.0),
    M(0.30),
    G(0.50);

    public final double multiplicador;

    TipoTamanho(double multiplicador) {
        this.multiplicador = multiplicador;
    }
}
