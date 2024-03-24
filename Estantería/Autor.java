/**
 * Clase Autor. Guarda los datos de un autor.
 **/
public class Autor{
    String nombre, apellidoPat, apellidoMat, nacionalidad;
    /**
     * Primer Constructor cuando no se tiene apellido materno
     **/
    public Autor(String nombre, String apellidoPat, String apellidoMat, String nacionalidad){
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.nacionalidad = nacionalidad;
    }
    /**
     * Segundo Constructor cuando no se tiene apellido materno
     **/
    public Autor(String nombre, String apellidoPat, String nacionalidad){
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        apellidoMat = "";
        this.nacionalidad = nacionalidad;
    }

    /**
     * Seters y Geters para los atributos de Autor
     **/
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    public String getNombre(){
        return nombre;
    }
    public void setApellidoPat(String apellidoPat){
        this.apellidoPat = apellidoPat;
    }
    public String getApellidoPat(){
        return apellidoPat;
    }
    public void setApellidoMat(String apellidoMat){
        this.apellidoMat = apellidoMat;
    }
    public String getApellidoMat(){
        return apellidoMat;
    }
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }
    public String getNacionalidad(){
        return nacionalidad;
    }

    public String toString(){
        if(apellidoMat != ""){
            return nombre+" "+apellidoPat+" "+apellidoMat+" Nacionalidad: "+nacionalidad;
        }
        else{
            return nombre+" "+apellidoPat+" Nacionalidad: "+nacionalidad;
        }

    }
}
