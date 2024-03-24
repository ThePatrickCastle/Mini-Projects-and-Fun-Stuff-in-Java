/**
 * Juego de Ahogado
 * Con este trabajo aprendí bastante sobre contadores y como aproximarse a diferentes condiciones, además de trabajar con cadenas de apoyo. No es un trabajo
 * elegante y el código es bastante horrible, pero puedes checarlo para revisar algunos detalles e implementaciones. Sobre todo lo más importante está
 * entre la línea 64 a 116. 
 **/
import java.util.Scanner;
import java.util.Random;
public class Ahogado{
    public static void main(String[]args){
        /**
         * Una practica que creí buena hasta el momento en el que estoy comentando el código es poner tus variables al inicio del código, 
         * en realidad, ahora desconozco si fue la mejor desición. Pero recomendaria más comentar tu código mientras lo armas. Sobretodo en 
         * la OOP se recomienda trabajar con funciones, comenta tus funciones en lugar de este relajo.
         **/
        Random alazar = new Random();
        Scanner teclado = new Scanner(System.in);
        int menu, nopartidas = 0, ganadas = 0, perdidas = 0;
        boolean salirmenu = false, está;
        String jugador, nombrepelicula = "";
        int peli = 0, vidas = 0, aciertos = 0;
        char letrausuario;

        /**
         * Aquí empieza la interfaz de usuario, le preguntamos su nombre y construímos un menú con las opciónes de Jugar, Estadísticas y Menú.
         **/
        System.out.println("----------------Ahogado----------------");
        System.out.print("Ingrese su nombre: ");
        jugador = teclado.nextLine();
        
        while(salirmenu == false){
            System.out.println("-----------------Menu------------------");
            System.out.println("1. Jugar");
            System.out.println("2. Estadísticas");
            System.out.println("3. Salir");
            menu = teclado.nextInt();
            switch(menu){
                /**
                 * Aquí una mala desición de implementacion. Cabe aclarar no nos permitieron usar arrays entonces se me perdona a mi, no a ustedes. 
                 * De preferencia no realicen así elecciones entre cosas del mismo objeto, utilicen arrays.
                 **/
            case 1:		
                System.out.println("-----------------Juego-----------------");
                peli = alazar.nextInt(10)+1;
                switch(peli){
                case 1:
                    nombrepelicula = "BATMAN";
                    break;
                case 2:
                    nombrepelicula = "INTERESTELAR";
                    break;
                case 3:
                    nombrepelicula = "MARSHALL";
                    break;
                case 4:
                    nombrepelicula = "PARKLAND";
                    break;
                case 5:
                    nombrepelicula = "MONEYBALL";
                    break;
                case 6:
                    nombrepelicula = "SHREK";
                    break;
                case 7:
                    nombrepelicula = "WHIPLASH";
                    break;
                case 8:
                    nombrepelicula = "CHRONICLE";
                    break;
                case 9:
                    nombrepelicula = "SNOWDEN";
                    break;
                case 10:
                    nombrepelicula = "MATRIX";
                    break;
                }
                vidas = 0;
                aciertos = 0;
                /**
                 * Tenemos una cadena que rellenaremos con guiones para ocultar la palabra al jugador
                 **/
                String peliculaoculta = "";
                for(int k = 0; k < nombrepelicula.length(); k++){
                    if(nombrepelicula.charAt(k) == ' '){
                        peliculaoculta = peliculaoculta+" ";
                    }
                    else{
                        peliculaoculta = peliculaoculta + "_";
                    }
                }
                System.out.println(peliculaoculta);
                /**
                 * Ahora usamos un switch inecesariamente para mostrar una interfaz con circulitos. Usen arrays!
                 **/
                while (vidas < 6 || aciertos == nombrepelicula.length()){  
                    switch(vidas){
                    case 0:
                        System.out.println("Vidas: O O O O O O");
                        break;
                    case 1:
                        System.out.println("Vidas: O O O O O");
                        break;
                    case 2:
                        System.out.println("Vidas: O O O O");
                        break;
                    case 3:
                        System.out.println("Vidas: O O O");
                        break;
                    case 4:
                        System.out.println("Vidas: O O");
                        break;
                    case 5:
                        System.out.println("Vidas: O");
                        break;
                    }
		    
                    /**
                     * Esta es la parte más interesante de la implementación. Primero 
                     * decidimos si la palabra está, luego la revelamos y modificamos nuestra cadena.
                     **/
                    está = false;
                    String adivinanza = "";
                    System.out.println("Ingrese una letra:");
                    letrausuario = teclado.next().toUpperCase().charAt(0);
                    for(int i = 0; i < nombrepelicula.length(); i++ ){
                        if(nombrepelicula.charAt(i) == letrausuario){
                            adivinanza = adivinanza + letrausuario;
                            aciertos++;
                            está = true;
       
                        } 
                        else{
                            adivinanza = adivinanza + peliculaoculta.charAt(i);
                        }
			
                    }
                    peliculaoculta = adivinanza;
                    System.out.println(peliculaoculta);
	    
                    if(aciertos == nombrepelicula.length()){
                        ganadas++;
                        System.out.println("Haz Ganado!");
                        break;
                    }      
                    if(está == false){
                        System.out.println("La letra no está en la pelicula");
                        vidas++;
                    }
                    /**
                     * Otro truco medio raro con cadenas.
                     **/
                    switch(vidas){
                    case 0:
                        System.out.println("   ");
                        System.out.println("   ");
                        System.out.println("   ");
                        break;
                    case 1:
                        System.out.println(" 0 ");
                        System.out.println("   ");
                        System.out.println("   ");
                        break;
                    case 2:
                        System.out.println(" 0 ");
                        System.out.println(" | ");
                        System.out.println("   ");
                        break;
                    case 3:
                        System.out.println(" 0 ");
                        System.out.println("/| ");
                        System.out.println("   ");
                        break;
                    case 4:
                        System.out.println(" 0 ");
                        System.out.println("/|\\");
                        System.out.println("   ");
                        break;
                    case 5:
                        System.out.println(" 0 ");
                        System.out.println("/|\\");
                        System.out.println("/  ");
                        break;
                    case 6:
                        System.out.println(" 0 ");
                        System.out.println("/|\\");
                        System.out.println("/ \\");
                        perdidas++;
                        System.out.println("Haz Perdido");
                        System.out.println("La pelicula era: "+nombrepelicula);
                        break;
                    }
                }			
                System.out.println("----------------------------------------");
                nopartidas++;
                break;
                /**
                 * Aqui termina parte del juego, luego seguimos imprimiendo las opciones por si el usuario desea checar las estadisticas.
                 **/
            case 2:
                System.out.println("--------------Estadísticas--------------");
                System.out.println("Total de Juegos: "+nopartidas);
                System.out.println("Victorias de "+jugador+": "+ganadas);
                System.out.println("Victorias de la computadora: "+perdidas);
                break;
            case 3:
                System.out.println("Gracias por jugar "+jugador+"!");
                salirmenu = true;
                break;
            default:
                System.out.println("Eliga una opcion valida");
                System.out.println("---------------------------------------");
                break;
            }
        }
    } 
}
