/**
 * Abajo hay un comentario gigante sobre algunas funcionalidades del juego. Perdon por mis comentarios xd. 
 * Esta fue una practica de primer semestre. Es un juego pokemon para que 2 personas jueguen en la misma terminal contra ellos.
 * Nota. Los personajes de fuego estan rotisimos.
 **/
/*
  El factor de daño que tome en cuenta son las siguientes relaciones:
  fuego -> fuego = 100%
  fuego -> agua = 63%
  fuego -> tierra = 100%
  tierra -> fuego = 160%
  tierra -> agua = 100%
  tierra -> tierra = 100%
  agua -> fuego = 160%
  agua -> agua = 100%
  agua -> tierra = 160%

  Intentando aproximarme a la información de la página.

  Este programa tiene como objetivo ser una plataforma en la que de preferencia
  2 usuarios con acceso a la misma computadora pudieran realizar enfrentamientos
  entre ellos (aunque tambien se puede jugar contra uno mismo). Por eso se toma
  cuenta la interfaz que incluye algunos detalles como:
  - Al atacar se muestra enseguida toda la informacion del enemigo
  - Al curarse se muestra la informacion del mismo pokemon

  Tambien se puen identificar 4 funciones claves:
  1. Atacar, recibe la eleccion de ataque del jugador y el pokemon atacado
  2. Oranberry, aumenta la vida del jugador con la mochila asociada
  3. Elixir, renueva los turnos del jugador
     -Este método esta implementado por una parte en Mochila que actualiza el
      valor del elixir una vez ya consumido
     -La otra parte actualiza un contador que se tiene como condicion para matar
      el ciclo de turnos. Es decir el jugador pierde si se le acaban los turnos.
  4. Obtener Monedas, transfiere las monedas de la mochila del perdedor al ganador

  La condicion de Confundido (Boolean) nos indica la probabilidad de que un pokemon
  falle un ataque. Se implementa en primer lugar las probabilidades con un random
  para resolver el comportamiento del pokemon, es decir, que falle o no los ataques.

  La segunda parte es lograr que el efecto se mantenga consistentemente por 2 turnos.
  Para esto se propone un contador (inicializado en 0) que disminuye en cada turno y
  que nos dice si la variable es menos o igual a 0 se setea Confundido como false.
  Cuando un ataque es exitoso se cambia el valor a 2 y entonces dura 2 turnos (en el
  caso más basico) esta "Confusion" que aumenta las probabilidades de fallar un ataque.

  Las condiciones de victoria son que el rival agote o Energia o Turnos.
  
 */

import java.util.Random;
import java.util.Scanner;

public class Actividad1{
    public static void main(String[]args){
	Random rn = new Random();
	Scanner teclado = new Scanner(System.in);
	int monedas1 = rn.nextInt(400)+1, monedas2 = rn.nextInt(400)+1;
	int velo1 = rn.nextInt(100)+1, velo2 = rn.nextInt(100)+1;
	int cont_ataques1 = 7, cont_ataques2 = 7;
	int elec, movimiento, cont_turno = 0, proba_confundido, proba_golpe, confundido1 = 0, confundido2 = 0;
	boolean turno;
	Pokemon p1 = new Pokemon("Charmander", "Fuego", 500, 0, false);
	p1.setVelocidad(velo1);
	Pokemon p2 = new Pokemon("Squirtle", "Agua", 500, 0, false);
	p2.setVelocidad(velo2);
	Mochila m1 = new Mochila(0, 1, 1);
	m1.setMonedas(monedas1);
	Mochila m2 = new Mochila(0, 1, 1);
	m2.setMonedas(monedas2);

	
	
	p1.setMochila(m1);
	p2.setMochila(m2);

	System.out.println("Batalla Pokemon");
	System.out.println("-----------Pokemon 1-----------");
	System.out.println(p1);
	System.out.println("-----------Pokemon 2-----------");
	System.out.println(p2);
	System.out.println("-------------------------------");

	if(p1.getVelocidad() >= p2.getVelocidad()){
	    turno = true;
	    System.out.println(p1.getNombre()+" es más rápido. Iniciará el enfrentamiento");
	}
	else{
	    turno = false;
	    System.out.println(p2.getNombre()+" es más rápido. Iniciará el enfrentamiento");
	}
	System.out.println("-------------------------------");
	System.out.println("Batalla");

	while(p1.getEnergia() >= 0 && p2.getEnergia() >= 0 && cont_ataques1 > 0 && cont_ataques2 > 0){   
	    if(turno){
		if(confundido1 <= 0){
		    p1.setConfundido(false);
		}
		System.out.println("Turno de "+p1.getNombre());
		System.out.println("Elige tu Opcion: ");
		System.out.println("1. Atacar");
		System.out.println("2. Curarte");
		System.out.println("Ataques restantes: "+cont_ataques1);
		elec = teclado.nextInt();
		switch(elec){
		case 1:
		    System.out.println("Ataques:");
		    if(p1.getTipo() == "Fuego"){
			System.out.println("1. Bola de Fuego");
			System.out.println("2. Anillo Ígneo");
			System.out.println("3. Giro Fuego");
			System.out.println("4. Puño Fuego");
		    }
		    else if(p1.getTipo() == "Tierra"){
			System.out.println("1. Excavar");
			System.out.println("2. Disparo Lodo");
			System.out.println("3. Terremoto");
			System.out.println("4. Tumba Rocas");
		    }
		    else if(p1.getTipo() == "Agua"){
			System.out.println("1. Burbuja");
			System.out.println("2. Pistola Agua");
			System.out.println("3. Hidrocañon");
			System.out.println("4. Hidrobomba");
		    }
		    movimiento = teclado.nextInt();
		    
		    proba_confundido = rn.nextInt(100)+1;
		    proba_golpe = rn.nextInt(100)+1;

		    if(p1.getConfundido() == false){
			if(proba_confundido < 80){
			    p1.ataca(movimiento, p2);
			    System.out.println("El ataque fue exitoso");
			    if(proba_golpe < 20){
				p2.setConfundido(true);
				confundido2= 2;
			    }
			}
			else{
			    System.out.println("El ataque falló");
			}
		    }
		    else{
			if(proba_confundido < 20){
			    p1.ataca(movimiento, p2);
			    System.out.println("El ataque fue exitoso");
			    if(proba_golpe < 20){
				p2.setConfundido(true);
				confundido2 = 2;
			    }
			}
			else{
			    System.out.println("El ataque falló");
			}
		    }
		    
		    System.out.println("-----------"+p2.getNombre()+"-----------");
		    System.out.println(p2);
		    cont_ataques1--;
		    break;
		case 2:
		    System.out.println("Elige algo de tu mochila");
		    System.out.println(m1.curaciones());
		    movimiento = teclado.nextInt();
		    if(movimiento == 1){
			m1.useOranBerry(p1);
		    }
		    if(movimiento == 2){
			if(m1.getElixir() == 1){   
			    cont_ataques1 = 7;
			    m1.setElixir(0);
			}
			else{
			    System.out.println("Ya no tienes elixir");
			}
		    }
		    System.out.println("-----------"+p1.getNombre()+"-----------");		    
		    System.out.println(p1);
		    break;
		}
		confundido1--;
		turno = false;
	    }
	    else{
		if(confundido2 <= 0){
		    p2.setConfundido(false);
		}
	        System.out.println("Turno de "+p2.getNombre());
		System.out.println("Elige tu Opcion: ");
		System.out.println("1. Atacar");
		System.out.println("2. Curarte");
		System.out.println("Ataques restantes: "+cont_ataques2);
		elec = teclado.nextInt();
		switch(elec){
		case 1:
		    System.out.println("Ataques:");
		    if(p2.getTipo() == "Fuego"){
			System.out.println("1. Bola de Fuego");
			System.out.println("2. Anillo Ígneo");
			System.out.println("3. Giro Fuego");
			System.out.println("4. Puño Fuego");
		    }
		    else if(p2.getTipo() == "Tierra"){
			System.out.println("1. Excavar");
			System.out.println("2. Disparo Lodo");
			System.out.println("3. Terremoto");
			System.out.println("4. Tumba Rocas");
		    }
		    else if(p2.getTipo() == "Agua"){
			System.out.println("1. Burbuja");
			System.out.println("2. Pistola Agua");
			System.out.println("3. Hidrocañon");
			System.out.println("4. Hidrobomba");
		    }
		    movimiento = teclado.nextInt();
		    proba_confundido = rn.nextInt(100)+1;
		    proba_golpe = rn.nextInt(100)+1;
		    if(p2.getConfundido() == false){
			if(proba_confundido < 80){
			    p2.ataca(movimiento, p1);
			    System.out.println("El ataque fue exitoso");
			    if(proba_golpe < 20){
				p1.setConfundido(true);
				confundido1 = 2;
			    }
			}
			else{
			    System.out.println("El ataque falló");
			}
		    }
		    else{
			if(proba_confundido < 20){
			    p2.ataca(movimiento, p1);
			    System.out.println("El ataque fue exitoso");
			    if(proba_golpe < 20){
				p1.setConfundido(true);
				confundido1 = 2;
			    }
			}
			else{
			    System.out.println("El ataque falló");
			}
		    }
		    System.out.println("-----------"+p1.getNombre()+"-----------");
		    System.out.println(p1);
		    cont_ataques2--;
		    break;
		case 2:
		    System.out.println("Elige algo de tu mochila");
		    System.out.println(m2.curaciones());
		    movimiento = teclado.nextInt();
		    if(movimiento == 1){
			m2.useOranBerry(p2);
		    }
		    if(movimiento == 2){
			if(m2.getElixir() == 1){   
			    cont_ataques2 = 7;
			    m2.setElixir(0);
			}
			else{
			    System.out.println("Ya no tienes elixir");
			}
		    }
		    System.out.println("-----------"+p2.getNombre()+"-----------");		    
		    System.out.println(p2);
		    break;
		}
		confundido2--;
		turno = true;
	    }
	    cont_turno++;
	    System.out.println("-------------------------------");
	}

	if(p1.getEnergia() <= 0 || cont_ataques1 < 1){
	    System.out.println("El ganador es "+p2.getNombre());
	    System.out.println("Ganó en "+cont_turno+" turnos");
	    if(cont_ataques1 < 1){
		System.out.println("A "+p1.getNombre()+" se le han acabado los turnos");
	    }
	    m2.obtenerMonedas(m1);
	    System.out.println("Monedas Finales: "+m2.getMonedas());
	}
	if(p2.getEnergia() <= 0 || cont_ataques2 < 1){
	    System.out.println("El ganador es "+p1.getNombre());
	    System.out.println("Ganó en "+cont_turno+" turnos");
	    if(cont_ataques2 < 1){
		System.out.println("A "+p2.getNombre()+" se le han acabado los turnos");
	    }
	    m1.obtenerMonedas(m2);
	    System.out.println("Monedas Finales: "+m1.getMonedas());
	}
    }
}
