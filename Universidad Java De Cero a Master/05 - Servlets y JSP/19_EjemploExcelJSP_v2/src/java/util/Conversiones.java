package util;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ismael Caballero
 */
public class Conversiones {
    
    private static final String FORMATO_FECHA = "dd-MM-yyyy";
    
    /**
     * Metodo que permite convertir una fecha en una cadeca con el formato especificado
     * @param fecha
     * @return 
     */
    public static String format (Date fecha){
        SimpleDateFormat format = new SimpleDateFormat(FORMATO_FECHA);
        return format.format(fecha);
    }
    
    public static String format (String fecha){
        SimpleDateFormat format = new SimpleDateFormat(FORMATO_FECHA);
        return format.format(fecha);
    }
}
