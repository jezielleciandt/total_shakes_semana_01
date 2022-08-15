package produto;


public enum TipoTamanho  {

    P(0.0),
    M(0.30),
    G(0.50);

    private final double multiplicador;

    TipoTamanho(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador() {
        return multiplicador;
    }
}
