package produto;

public enum TipoTamanho {
    P(1), M(1.3), G(1.5);
    public final double multiplicador;

    TipoTamanho(double multiplicador) {
        this.multiplicador = multiplicador;
    }
}
