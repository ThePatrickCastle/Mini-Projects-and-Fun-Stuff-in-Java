/**
 * Clase LibroInfantil. Clase hija de libro que contiene ilustraciones y el numero de ilustraciones.
 **/
public class LibroInfantil extends Libro{
    boolean ilustraciones;
    int no_ilustraciones;
    /**
     * Constructor de Libroinfantil. Utilizamos super para llamar al constructor de Libro.
     **/
    public LibroInfantil(int isbn, String titulo, Autor a1, String editorial, String genero, int año_impresion, int numero_pag, boolean ilustraciones, int no_ilustraciones){
        super(isbn, titulo, a1, editorial, genero, año_impresion, numero_pag);
        this.ilustraciones = ilustraciones;
        this.no_ilustraciones = no_ilustraciones; 
    }
    
    /**
     * Seters y Geters para los atributos de Libroinfantil
     **/
    public void setIlustraciones(boolean ilustraciones){
        this.ilustraciones = ilustraciones;
    }
    public boolean getIlustraciones(){
        return ilustraciones;
    }
    public void setNoIlustraciones(int no_ilustraciones){
        this.no_ilustraciones = no_ilustraciones;
    }
    public int getNoIlustraciones(){
        return no_ilustraciones;
    }

    public String toString(){ 
        return "Libro Infantil: "+titulo+" de "+a1+" con "+no_ilustraciones+" ilustraciones"+"\n"+
            "Editorial: "+editorial+"\n"+
            "Año de Publicacion: "+año_impresion+" Genero: "+genero+" No. de Paginas: "+numero_pag+" ISBN: "+isbn; 
    }
    
}
