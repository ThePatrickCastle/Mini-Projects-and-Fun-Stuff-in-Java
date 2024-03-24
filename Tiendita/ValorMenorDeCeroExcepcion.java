/**
 * Detecta si el usuario ingresa un valor invalido, es decir negativo a un producto.
 **/
public class ValorMenorDeCeroExcepcion extends Exception{
    public ValorMenorDeCeroExcepcion(String mensaje){
        super(mensaje);
    }
}
