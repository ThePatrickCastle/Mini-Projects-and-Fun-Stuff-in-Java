/**
 * Esta excepcion detecta cuando una cadena no tiene solamente caracteres en mayusculas
 **/
public class FormatoMayusculasNombreExcepcion extends Exception{
    public FormatoMayusculasNombreExcepcion(String mensaje){
        super(mensaje);
    }
}
