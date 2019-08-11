
package com.icaballero.jsf.bean.helper;

import com.icaballero.jsf.bean.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@RequestScoped
@Named
public class ColoniaHelper {
    
    /**
     * Generar lista de colonias
     * @return 
     */
    public List<Colonia> getColonias(){
        
        List<Colonia> colonias = new ArrayList<>();
        
        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Napoles", 3810);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Polanco", 11530);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Del Valle Centro", 3100);
        colonias.add(colonia);
        
        
        return colonias;
    }
    
    
    /**
     * Busqueda por nombre
     * @param nombreColonia
     * @return 
     */
    public int getColoniaIdPorNombre(String nombreColonia){
        int coloniaId= 0;
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            if(colonia.getNombreColonia().equals(nombreColonia)){
                coloniaId = colonia.getColoniaId();
                break;
            }
            
        }
        
        return coloniaId;
    }
    
    /**
     * Busqueda por codigo postal
     * @param codigoPostal
     * @return 
     */
    public int getColoniaIdPorCP(int codigoPostal){
        int coloniaId= 0;
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            if(colonia.getCodigoPostal() == codigoPostal){
                coloniaId = colonia.getColoniaId();
                break;
            }
            
        }
        
        return coloniaId;
    }
    
    
    
    /**
     * Pasar la lista de colonias a SelectItems para mostrarlo en la vista
     * @return 
     */
    public List<SelectItem> getSelectItems(){
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(),colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        
        return selectItems;
        
    }
    
    
    
}
