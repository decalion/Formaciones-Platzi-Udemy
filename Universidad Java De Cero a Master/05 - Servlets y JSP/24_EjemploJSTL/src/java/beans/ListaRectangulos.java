package beans;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ismael
 */
public class ListaRectangulos {

    
   private List<Rectangulo> lista = new ArrayList<>();
     
    public void setLista(List<Rectangulo> lista) {
        this.lista = lista;
    }

  public void setRectangulo(Rectangulo r){
      
      this.lista.add(r);
  }
  
  public List<Rectangulo> getLista(){
      return lista;
  }
  
  
  
}
