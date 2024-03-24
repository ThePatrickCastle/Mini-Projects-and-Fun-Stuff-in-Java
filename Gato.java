/**
 * Juego de 2 Jugadores Gato
 * @author Carillo González Luis Israel
 * @author González Castillo Patricio Salvador
 * @version (17.10.23)
 */
import java.util.Scanner;
public class Gato{
    /**
     * Metodo imprimirvictoria. Este metodo esta totalmente mal xd. Estamos haciendo 2 veces la misma revision con otro método, pero bueno, revisamos por la condicion de victoria en el tablero y
     * en caso de darse pues imprimimos un mensaje.
     * @params tablero La matriz que funciona como tablero de juego
     * @params a El simbolo que utiliza el jugador en turno
     **/
    public static void imprimirVictoria(char [][] tablero, char a){
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == a && tablero[i][1] == a && tablero[i][2] == a) {
                System.out.println("El jugador con "+a+" Ha ganado por Fila");
            }
            if (tablero[0][i] == a && tablero[1][i] == a && tablero[2][i] == a) {
                System.out.println("El jugador con "+a+" Ha ganado por Columna");
            }
        }
        if(tablero[0][0] == a && tablero[1][1] == a && tablero[2][2] == a){
            System.out.println("El jugador con "+a+" Ha ganado por Diagonal");
        }
        if(tablero[0][2] == a && tablero[1][1] == a && tablero[2][0] == a){
            System.out.println("El jugador con "+a+" Ha ganado por Diagonal Invertida");
        }
    }

    /**
     * Metodo comprobarVictoria. Revisa si un jugador tiene el patron con la condicion ganadora
     * @params tablero El arreglo de chars que se modifica.
     * @params a El simbolo del jugador en turno.
     * @return verdadero o falso. Depende si el jugador en turno tiene en el tablero el patrón ganador.
     **/
    public static boolean comprobarVictoria(char [][] tablero, char a){
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == a && tablero[i][1] == a && tablero[i][2] == a) {
                return true;
            }
            if (tablero[0][i] == a && tablero[1][i] == a && tablero[2][i] == a) {
                return true;
            }
        }
        if(tablero[0][0] == a && tablero[1][1] == a && tablero[2][2] == a){
            return true;
        }
        if(tablero[0][2] == a && tablero[1][1] == a && tablero[2][0] == a){
            return true;
        }
        return false;
    }

    /**
     * Metodo comprobar tablero. Si el tablero ya no contiene "-" y no ha ganado nadie, entonces se devuelve verdadero.
     * @params tablero El arreglo de chars que sirve de tablero
     * @return verdadero o falso
     **/
    public static boolean comprobarEmpate(char [][] tablero){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                if(tablero[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);
        int turno = 0, opc_fila, opc_columna;
        boolean victoria1 = false, victoria2 = false, empate = false;
        char [][] tablero = new char[3][3];
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                tablero[i][j] = '-';
            }
        }

        /**
         * Un problema grave es que repetimos 2 veces el código en el que imprimimos el tablero, solamente se hace un método y despues se invoca al final del ciclo while.
         * No borro ni corrijo esto porque me recuerda que siempre se puede mejorar y los ojos con los que veo este código que hice en el pasado deben ser los ojos con los que 
         * mi yo del futuro ve mis codigos de hoy.
         **/
        System.out.println("Gato");
        while(victoria1 == false && victoria2 == false && empate == false){
            if(turno == 0){
                System.out.println("Turno jugador 1: (X)");
                for(int m = 0; m < tablero.length; m++){
                    for(int n = 0; n < tablero.length; n++){
                        System.out.print(tablero[m][n]);
                    }
                    System.out.println();
                }
                do{
                    System.out.println("Ingresa fila: ");
                    opc_fila = teclado.nextInt();
                    System.out.println("Ingrsa columna: ");
                    opc_columna = teclado.nextInt();	       
                    if(tablero[opc_fila][opc_columna] == '-'){
                        tablero[opc_fila][opc_columna] = 'X';
                        turno = 1;
                    }
		    
                    else{
                        System.out.println("Casilla Ocupada. Intenta otra vez");
                    }
                }while(tablero[opc_fila][opc_columna] == '-');	
                imprimirVictoria(tablero,'X');
                if(comprobarVictoria(tablero, 'X')){
                    victoria1 = true;
                }
            }
            else if(turno == 1){	
                System.out.println("Turno jugador 2: (O)");
                for(int o = 0; o < tablero.length; o++){
                    for(int p = 0; p < tablero.length; p++){
                        System.out.print(tablero[o][p]);
                    }
                    System.out.println();
                }
		
                do{
                    System.out.println("Ingresa fila: ");
                    opc_fila = teclado.nextInt();
                    System.out.println("Ingrsa columna: ");
                    opc_columna = teclado.nextInt();	       
                    if(tablero[opc_fila][opc_columna] == '-'){
                        tablero[opc_fila][opc_columna] = 'O';
                        turno = 0;
                    }	
                    else{
                        System.out.println("Casilla Ocupada. Intenta otra vez");
                    }
                }while(tablero[opc_fila][opc_columna] == '-');
                imprimirVictoria(tablero,'O');
                if(comprobarVictoria(tablero, 'O')){
                    victoria2 = true;
                }
            }
            empate = comprobarEmpate(tablero);
        }
        if(empate){
            System.out.println("El juego se cerró. Es un empate");
        }
    }
}    
