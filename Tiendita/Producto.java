/**
 * Clase Producto. Guarda el nombre de un producto, su existencia y la cantidad de productos vendidos hasta ese punto.
 **/
public class Producto{
    String nombre, vendidos;
    int existencia;
    /**
     * Constructor de clase.
     **/
    public Producto(String nombre, int existencia, String vendidos){
        this.nombre = nombre;
        this.existencia = existencia;
        this.vendidos = vendidos;
    }
    /**
     * Seters y Geters para los atributos del producto.
     **/
    public void setNombre(String nombre){
        this.nombre = nombre; 
    } 
    public String getNombre(){
        return nombre; 
    }
    public void setExistencia(int existencia){
        this.existencia = existencia;
    }
    public int getExistencia(){
        return existencia;
    }
    public void setVendidos(String vendidos){
        this.vendidos = vendidos;
    }
    public String getVendidos(){
        return vendidos;
    }
    public String toString(){
        return nombre+"\nExistencia "+existencia+"\nVendido "+vendidos;
    }
}
