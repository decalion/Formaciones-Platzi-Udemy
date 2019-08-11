package com.icaballero.jsf.bean.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@FacesConfig(

        //Activa el CDI para los beans que se van a agregar
        version = JSF_2_3
)
@ApplicationScoped
public class ConfigurationJSF {
    
    
    
}
