package produto;

import java.util.Arrays;
import java.util.Optional;

public enum TipoTamanho {
    P(0.0, 'P'){
        @Override
        public double getPreco(double precoBase) {
            return precoBase;
        }
    },
    M(0.30, 'M'){
        @Override
        public double getPreco(double precoBase) {
            return precoBase + (precoBase * M.multiplicador);
        }
    },
    G(0.50, 'G'){
        @Override
        public double getPreco(double precoBase) {
            return precoBase + (precoBase * G.multiplicador);
        }
    };
    public final double multiplicador;
    public final char charTamanho;

    TipoTamanho(double multiplicador, char charTamanho){
        this.multiplicador = multiplicador;
        this.charTamanho = charTamanho;
    }

    public abstract double getPreco(double precoBase);
    public static TipoTamanho getTipoTamanho(char tamanho){
        Optional<TipoTamanho> optTipoTamanho = Arrays.stream(values())
                .filter(tipoTamanho -> tipoTamanho.charTamanho == tamanho)
                .findFirst();

        if(optTipoTamanho.isPresent()){
            return optTipoTamanho.get();
        }
        throw new IllegalArgumentException("Tamanho não existe no cardápio.");
    }

}