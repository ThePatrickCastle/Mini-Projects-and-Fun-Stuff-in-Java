/**
 * Clase Libro. Contiene los atributos de un libro para su venta en una tienda digital.
 **/
public class Libro{
    int isbn, año_impresion, numero_pag;
    String titulo, editorial, genero;
    Autor a1;
    /**
     * Constructor de Libro
     **/
    public Libro(int isbn, String titulo, Autor a1, String editorial, String genero, int año_impresion, int numero_pag){
        this.isbn = isbn;
        this.titulo = titulo;
        this.a1 = a1;
        this.editorial = editorial;
        this.genero = genero;
        this.año_impresion = año_impresion;
        this.numero_pag = numero_pag;
    } 
    /**
     * Seters y Geters de los atributos de libro
     **/
    public void setISBN(int isbn){
        this.isbn = isbn;
    }
    public int getISBN(){
        return isbn;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setAutor(Autor a1){
        this.a1 = a1;
    }
    public Autor getAutor(){
        return a1;
    }
    public void setEditorial(String editorial){
        this.editorial = editorial;
    }
    public String getEditorial(){
        return editorial;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getGenero(){
        return genero;
    }
    public void setAñoImpresion(int año_impresion){
        this.año_impresion = año_impresion;
    }
    public int getAñoImpresion(){
        return año_impresion;
    }
    public void setNoPaginas(int numero_pag){
        this.numero_pag = numero_pag;
    }
    public int getNoPaginas(){
        return numero_pag;
    }
    
    public String toString(){
        return "Libro: "+titulo+" Autor: "+a1+" Editorial: "+editorial+"\n"+
            "Año de Publicacion: "+año_impresion+" Genero: "+genero+" No. de Paginas: "+numero_pag+" ISBN: "+isbn;
    }


}
