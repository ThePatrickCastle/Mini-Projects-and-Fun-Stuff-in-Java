/**
 * Clase Carta. Contiene un valor, palo y una capa que permite identificar al valor de un palo como una letra en el toString
 *
 **/
public class Carta{
    int valor;
    char palo;
    String verValor = "";
    /**
     * Constructor de Carta
     * @params valor, palo
     **/
    public Carta(int valor, char palo){
        this.valor = valor;
        this.palo = palo;
    }
    /**
     * Seters y Geters para los parametros de la carta
     **/
    public void setValor(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
    public void setPalo(char palo){
        this.palo = palo;
    }
    public int getPalo(){
        return palo;
    }
    public String getVerValor(){
        if(valor == 1){
            return verValor = "A";
        }
        if(valor == 11){
            return verValor = "J";
        }
        if(valor == 12){
            return verValor = "Q";
        }
        if(valor == 13){
            return verValor = "K";
        }
        else{
            return verValor = ""+this.valor+"";
        }
    }

    public String toString(){
        return ""+this.getVerValor()+""+palo;
    }
    
}
