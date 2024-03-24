/**
 * Clase que contiene los atributos de un pokemos y tambien su mochila.
 **/
public class Pokemon{
    String nombre, tipo;
    int energia, velocidad;
    boolean confundido;
    Mochila mochila;
    
    /**
     * Constructor de Pokemon
     **/
    public Pokemon(String nombre, String tipo, int energia, int velocidad, boolean confundido){
	this.nombre = nombre;
	this.tipo = tipo;
	this.energia = energia;
	this.velocidad = velocidad;
	this.confundido = confundido;
    }

    /**
     * Seters y Geters de los atributos del pokemon
     **/
    public String getNombre(){
	return nombre;
    }
    public void setNombre(String nombre){
	this.nombre = nombre;
    }
    public String getTipo(){
	return tipo;
    }
    public void setTipo(String tipo){
	this.tipo = tipo;
    }
    public int getEnergia(){
	return energia;
    }
    public void setEnergia(int energia){
	this.energia = energia;
    }
    public int getVelocidad(){
	return velocidad;
    }
    public void setVelocidad(int velocidad){
	this.velocidad = velocidad;
    }
    public boolean getConfundido(){
	return confundido;
    }
    public void setConfundido(boolean confundido){
	this.confundido = confundido;
    }
    public Mochila getMochila(){
	return mochila;
    }
    public void setMochila(Mochila mochila){
	this.mochila = mochila;
    }

    /**
     * Metodo ataca. Es el metodo que determina que ataque se lanzará que daño recibira el pokemon oponente.
     **/
    public void ataca(int movimiento, Pokemon p){
	if(this.getTipo() == "Fuego"){
	    switch(p.getTipo()){
	    case "Fuego":
		switch(movimiento){
		case 1:
		    System.out.println("Fuego: Bola de Fuego. Daño Base: 60");
		    p.setEnergia(energia - 60);
		    break;
		case 2:
		    System.out.println("Fuego: Anillo Ígneo. Daño Base: 70");
		    p.setEnergia(energia - 70);
		    break;
		case 3:
		    System.out.println("Fuego: Giro Fuego. Daño Base: 80");
		    p.setEnergia(energia - 80);
		    break;
		case 4:
		    System.out.println("Fuego: Puño Fuego. Daño Base: 90");
		    p.setEnergia(energia - 90);
		    break;
		}		
		break;
	    case "Agua":
		switch(movimiento){
		case 1:
		    System.out.println("Fuego: Bola de Fuego. Daño Base: 60");
		    p.setEnergia(energia - 38);
		    break;
		case 2:
		    System.out.println("Fuego: Anillo Ígneo. Daño Base: 70");
		    p.setEnergia(energia - 44);
		    break;
		case 3:
		    System.out.println("Fuego: Giro Fuego. Daño Base: 80");
		    p.setEnergia(energia - 50);
		    break;
		case 4:
		    System.out.println("Fuego: Puño Fuego. Daño Base: 90");
		    p.setEnergia(energia - 58);
		    break;
		}
		break;
	    case "Tierra":
		switch(movimiento){
	        case 1:
		    System.out.println("Fuego: Bola de Fuego. Daño Base: 60");
		    p.setEnergia(energia - 60);
		    break;
		case 2:
		    System.out.println("Fuego: Anillo Ígneo. Daño Base: 70");
		    p.setEnergia(energia - 70);
		    break;
		case 3:
		    System.out.println("Fuego: Giro Fuego. Daño Base: 80");
		    p.setEnergia(energia - 80);
		    break;
		case 4:
		    System.out.println("Fuego: Puño Fuego. Daño Base: 90");
		    p.setEnergia(energia - 90);
		    break;
		}
		break;
	    }
	}
	else if(this.getTipo() == "Agua"){
	    switch(p.getTipo()){
	    case "Fuego":
		switch(movimiento){
		case 1:
		    System.out.println("Agua: Burbuja. Daño Base: 40");
		    p.setEnergia(energia - 64);
		    break;
		case 2:
		    System.out.println("Agua: Pistola Agua. Daño Base: 50");
		    p.setEnergia(energia - 80);
		    break;
		case 3:
		    System.out.println("Agua: Hidrocañon. Daño Base: 60");
		    p.setEnergia(energia - 96);
		    break;
		case 4:
		    System.out.println("Agua: Hidrobomba: Daño Base: 50");
		    p.setEnergia(energia - 80);
		    break;
		}
		break;
	    case "Agua":
		switch(movimiento){
		case 1:
		    System.out.println("Agua: Burbuja. Daño Base: 40");
		    p.setEnergia(energia - 40);
		    break;
		case 2:
		    System.out.println("Agua: Pistola Agua. Daño Base: 50");
		    p.setEnergia(energia - 50);
		    break;
		case 3:
		    System.out.println("Agua: Hidrocañon. Daño Base: 60");
		    p.setEnergia(energia - 60);
		    break;
		case 4:
		    System.out.println("Agua: Hidrobomba: Daño Base: 50");
		    p.setEnergia(energia - 50);
		    break;
		}
		break;
	    case "Tierra":
		switch(movimiento){
		case 1:
		    System.out.println("Agua: Burbuja. Daño Base: 40");
		    p.setEnergia(energia - 64);
		    break;
		case 2:
		    System.out.println("Agua: Pistola Agua. Daño Base: 50");
		    p.setEnergia(energia - 80);
		    break;
		case 3:
		    System.out.println("Agua: Hidrocañon. Daño Base: 60");
		    p.setEnergia(energia - 96);
		    break;
		case 4:
		    System.out.println("Agua: Hidrobomba: Daño Base: 50");
		    p.setEnergia(energia - 80);
		    break;
		}
		break;
	    }
	}
	else if(this.getTipo() == "Tierra"){
	    switch(p.getTipo()){
	    case "Fuego":
		switch(movimiento){
		case 1:
		    System.out.println("Tierra: Excavar. Daño Base: 50");
		    p.setEnergia(energia - 80);
		    break;
		case 2:
		    System.out.println("Tierra: Disparo Lodo. Daño Base: 40");
		    p.setEnergia(energia - 64);
		    break;
		case 3:
		    System.out.println("Tierra: Terremoto. Daño Base 50");
		    p.setEnergia(energia - 80);
		    break;
		case 4:
		    System.out.println("Tierra: Tumba Rocas. Daño Base 60");
		    p.setEnergia(energia - 96);
		    break;
		}
		break;
	    case "Agua":
		switch(movimiento){
		case 1:
		    System.out.println("Tierra: Excavar. Daño Base: 50");
		    p.setEnergia(energia - 50);
		    break;
		case 2:
		    System.out.println("Tierra: Disparo Lodo. Daño Base: 40");
		    p.setEnergia(energia - 40);
		    break;
		case 3:
		    System.out.println("Tierra: Terremoto. Daño Base 50");
		    p.setEnergia(energia - 50);
		    break;
		case 4:
		    System.out.println("Tierra: Tumba Rocas. Daño Base 60");
		    p.setEnergia(energia - 60);
		    break;
		}
		break;
	    case "Tierra":
		switch(movimiento){
		case 1:
		    System.out.println("Tierra: Excavar. Daño Base: 50");
		    p.setEnergia(energia - 50);
		    break;
		case 2:
		    System.out.println("Tierra: Disparo Lodo. Daño Base: 40");
		    p.setEnergia(energia - 40);
		    break;
		case 3:
		    System.out.println("Tierra: Terremoto. Daño Base 50");
		    p.setEnergia(energia - 50);
		    break;
		case 4:
		    System.out.println("Tierra: Tumba Rocas. Daño Base 60");
		    p.setEnergia(energia - 60);
		    break;
		}
		break;
	    }
	}
    }

    public String toString(){
	return "Nombre: "+nombre+
	       "\nTipo: "+tipo+
	       "\nEnergia: "+energia+
	       "\nVelocidad: "+velocidad+
	    "\nConfundido: "+confundido+"\n"+mochila;
    }
    
}
