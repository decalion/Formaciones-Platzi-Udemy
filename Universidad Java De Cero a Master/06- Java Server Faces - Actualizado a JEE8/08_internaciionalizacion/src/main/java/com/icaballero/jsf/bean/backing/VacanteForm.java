package com.icaballero.jsf.bean.backing;

import com.icaballero.jsf.bean.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {

    @Inject
    private Candidato candidato;

    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        
        log.info("Creando el Objeto VacanteForm");
    }
    
    
    
    
    public void setCandidato(Candidato candidato) {

        this.candidato = candidato;

    }

    public String enviar() {

        if (this.candidato.getNombre().equals("Ismael")) {
            
            if(this.candidato.getApellido().equals("Caballero")){
                
                String msg = "Gracias, pero Ismael Caballero ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;//Mensaje global
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando al caso de fallo");
           
            return "fallo";

        }

    }
    
}
