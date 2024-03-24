/**
 * Clase Mochila. Guarda las curas y la cantidad de monedas que tiene un pokemon.
 **/
public class Mochila{
    int monedas;
    int oranberry, elixir;
    /**
     * Constructor de mochila
     **/
    public Mochila(int monedas, int oranberry, int elixir){
        this.monedas = monedas;
        this.oranberry = oranberry;
        this.elixir = elixir;
    }
    /**
     * Seters y Getes de los atributos de mochila.
     **/
    public int getMonedas(){
        return monedas;
    }
    public void setMonedas(int monedas){
        this.monedas = monedas;
    }
    public int getOranBerry(){
        return oranberry;
    }
    public void setOranBerry(int oranberry){
        this.oranberry = oranberry;
    }
    public int getElixir(){
        return elixir;
    }
    public void setElixir(int elixir){
        this.elixir = elixir;
    }

    /**
     * Este método se asegura que solo puedan utilizar una oranBerry (Que aumenta su vida)
     **/
    public void useOranBerry(Pokemon p){
        if(this.getOranBerry() == 1){
            if(p.getEnergia() >= 300){
                p.setEnergia(500);
            }
            else{
                p.setEnergia(p.getEnergia() + 200);
            }
            this.setOranBerry(0);
        }
        else{
            System.out.println("Ya no tienes Oran Berrys");
        }
    }

    /**
     * Metodo obtenermonedas. Suma las monedas de la mochila del otro pokemon y luego setea esas monedas a 0.
     **/
    public void obtenerMonedas(Mochila m){
        this.setMonedas(this.getMonedas() + m.getMonedas());
        m.setMonedas(0);
    }
  
    public String toString(){
        return "Mochila:"+
            "\n Monedas: "+monedas+
            "\n OranBerry: "+oranberry+
            "\n Elixir: "+elixir;
    }

    public String curaciones(){
        return "Mochila:"+
            "\n 1. OranBerry: "+oranberry+
            "\n 2. Elixir: "+elixir;
    }
}
