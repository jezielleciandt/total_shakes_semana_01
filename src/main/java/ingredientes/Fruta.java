package ingredientes;

public class Fruta  implements Adicional,Comparable<Ingrediente>{
     private TipoFruta tipoFruta;

     public Fruta(TipoFruta tipoFruta) {
          this.tipoFruta = tipoFruta;
     }

     public TipoFruta getTipoFruta(){
          return this.tipoFruta;
     }


     //É necessário consertar o compareTo, para imprimir na ordem correta.
     @Override
     public int compareTo(Ingrediente ingrediente) {
          return ingrediente.obterTipo().toString().compareTo(this.obterTipo().toString());
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
