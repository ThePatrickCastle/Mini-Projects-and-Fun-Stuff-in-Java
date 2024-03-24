/**
 * Clase Caballo. Nos permite guardar los valores de fila y columna de un objeto caballo.
 **/
public class Caballo{
    int fila, columna;
    public Caballo(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    public void setFila(int fila){
        this.fila = fila;
    }
    public int getFila(){
        return fila;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }
    public int getColumna(){
        return columna;
    }
}
