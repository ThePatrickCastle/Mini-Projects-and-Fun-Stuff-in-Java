/**
 * Perdon por la forma de comentar, es recuerdo de esos momentos.
 * Proyecto 3 Actividad 2
 * Este programa es una implementacion del juego 4 en linea. Es un juego de turnos contra la computadora.
 * el objetivo del juego es conseguir que 4 "Fichas" esten conectadas en una diagonal o linea recta. La
 * dinámica es por turnos. Se implementan 6 metodos principales y se reutiliza el código de la primera actividad
 * para buscar un arreglo de 4 simbolos iguales de tal forma que a la maquina le toque un simbolo, al usuario
 * otro y cuenten constantemente el numero de elementos conectados hay en la matriz.
 * @author González Castillo Patricio Salvador
 * @version (14.12.23)
 */  

public class Actividad2{
    public static void main(String[]args){
        Metodos2 mia = new Metodos2();
	char [][] juego = new char[7][7];
	char [] ganaHumano = {'X','X','X','X'};
	char [] ganaMaquina = {'Y','Y','Y','Y'};

	System.out.println("Juego Cuatro en Raya");
	
	mia.crearJuego(juego); // Se crea el juego (Se rellena la matriz)
	mia.imprimirJuego(juego); // Se imprime en la terminal
	// Y comienza a pedir el turno del usuario y ejecuta automáticamente el turno de la maquina, luego actualiza la imagen del tablero
	// El ciclo se cumple hasta que una de 2 cosas pasen. O el tablero se llena en cuyo caso el ciclo se rompe o se vuelve true la condicion
	// de que se encontro el arreglo o ganaHumano o ganaMaquina. 
	do{
	    mia.turnoUsuario();
	    mia.colocarFicha(juego);
	    mia.turnoComputadora();
	    mia.colocarFicha(juego);
	    mia.imprimirJuego(juego);
	}while(mia.verificarTablero(juego) && !mia.buscarEnJuego(juego, ganaHumano) && !mia.buscarEnJuego(juego, ganaMaquina));    
    }
}
