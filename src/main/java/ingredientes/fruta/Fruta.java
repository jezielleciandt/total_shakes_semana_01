package ingredientes.fruta;

import ingredientes.Adicional;
import ingredientes.Ingrediente;

public class Fruta  implements Adicional,Comparable<Ingrediente>{

     private static final long serialVersionUID = 1L;

     private final TipoFruta tipoFruta;

     public Fruta(TipoFruta tipoFruta) {
          this.tipoFruta = tipoFruta;
     }

     @Override
     public TipoFruta obterTipo() {
          return this.tipoFruta;
     }

     @Override
     public int compareTo(Ingrediente ingrediente) {
          return this.obterTipo().toString().compareTo(ingrediente.obterTipo().toString());
     }

     @Override
     public String toString() {
          return this.tipoFruta.toString();
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
}
