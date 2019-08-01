package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ismael
 */

@RequestScoped
@Named
public class VacanteForm {
    
    @Inject
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
        
    }
    
    
    public String enviar(){
        
        if(this.candidato.getNombre().equals("Ismael")){
            return "exito";
        }else{
            return "fallo";
        }
    }
    
    
    
}
