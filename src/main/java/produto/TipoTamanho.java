package produto;

public enum TipoTamanho {

    P("pequeno (default)", 1), M("medio", 1.3), G("grande", 1.5);

    private double multiplicador;
    private String description;

    TipoTamanho(String description, double multiplicador){
        this.multiplicador = multiplicador;
        this.description = description;
    }

    public double getMultiplicador() {
        return multiplicador;
    }

    public String getDescription() {
        return description;
    }
}
