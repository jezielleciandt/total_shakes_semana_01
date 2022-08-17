package ingredientes;

import java.io.Serializable;

public class Fruta  implements Adicional,Comparable<Ingrediente>, Serializable {
     private static final long serialVersionUID = 1L;
     private TipoFruta tipoFruta;

     public Fruta(TipoFruta tipoFruta) {
          this.tipoFruta = tipoFruta;
     }

     public TipoFruta getTipoFruta(){
          return this.tipoFruta;
     }

     @Override
     public int compareTo(Ingrediente ingrediente) {
          return this.obterTipo().toString().compareTo(ingrediente.obterTipo().toString());
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof Fruta)) return false;

          Fruta fruta = (Fruta) o;

          return tipoFruta == fruta.tipoFruta;
     }

     @Override
     public int hashCode() {
          return tipoFruta.hashCode();
     }

     @Override
     public String toString() {
          return this.tipoFruta.toString();
     }

     @Override
     public Enum obterTipo() {
          return this.tipoFruta;
     }

}