/**
 * Esta excepcion nos permite detectar cuando falta un punto en una cadena  
 **/
public class FaltaPuntoExcepcion extends Exception{
    public FaltaPuntoExcepcion(String mensaje){
        super(mensaje);
    }
}
