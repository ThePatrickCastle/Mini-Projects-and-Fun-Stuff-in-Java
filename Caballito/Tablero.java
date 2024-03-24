/**
 * En esta clase utilizaremos una matriz para simular el movimiento del caballo de una forma super ineficiente. Pero sirve para aprender sobre las matrices xd.
 **/
import java.util.Scanner;
public class Tablero{
    Scanner teclado2 = new Scanner(System.in);
    char [][] tablero = new char[8][8];
    int opc_fila = 7, opc_columna = 6;
    Caballo caballito = new Caballo(opc_fila, opc_columna);
    int x = caballito.getFila();
    int y = caballito.getColumna();
    
    /**
     * Metodo inicializartablero. Rellena el tablero de guiones bajos y despues pone al caballo en su posición y le asigna la letra C.
     **/
    public void inicializarTablero(){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                tablero[i][j] = '-';
            }
        }	
        tablero[caballito.getFila()][caballito.getColumna()] = 'C';
    }
    /**
     * Metodo calcularposicion. Calculamos las posiciones que estan dentro del array. Si no no es movimiento.
     **/
    public void calcularPosicion(){
        System.out.println("Movimientos Disponibles:");
        if(x+2 >= 0 && x+2 <= 7){
            if(y+1 >= 0 && y+1 <= 7){
                System.out.println("1. x = "+(x+2)+" y = "+(y+1));
            }
        }
        if(x+2 >= 0 && x+2 <= 7){
            if(y-1 >= 0 && y-1 <= 7){
                System.out.println("2. x = "+(x+2)+" y = "+(y-1));
            }
        }
        if(x-2 >= 0 && x-2 <= 7){
            if(y+1 >= 0 && y+1 <= 7){
                System.out.println("3. x = "+(x-2)+" y = "+(y+1));
            }
        }
        if(x-2 >= 0 && x-2 <= 7){
            if(y-1 >= 0 && y-1 <= 7){
                System.out.println("4. x = "+(x-2)+" y = "+(y-1));
            }
        }
        //
        if(x+1 > 0 && x+1 < 7){
            if(y+2 > 0 && y+2 < 7){
                System.out.println("5. x = "+(x+1)+" y = "+(y+2));
            }
        }
        if(x+1 >= 0 && x+1 <= 7){
            if(y-2 >= 0 && y-2 <= 7){
                System.out.println("6. x = "+(x+1)+" y = "+(y-2));
            }
        }
        if(x-1 >= 0 && x-1 <= 7){
            if(y+2 >= 0 && y+2 <= 7){
                System.out.println("7. x = "+(x-1)+" y = "+(y+2));
            }
        }
        if(x-1 >= 0 && x-1 <= 7){
            if(y-2 >= 0 && y-2 <= 7){
                System.out.println("8. x = "+(x-1)+" y = "+(y-2));
            }
        }
    }
    /**
     * Metodo movercaballo. El usuario elige su movimiento y despues se ejecuta con un switch.
     **/
    public void moverCaballo(){
        int opc_usuario = 0;
        System.out.println("Ingrese la opción deseada");
        opc_usuario = teclado2.nextInt();
        switch(opc_usuario){
        case 1:
            caballito.setFila(x+2);
            caballito.setColumna(y+1);
            tablero[x][y] = '-';
            x = x+2;
            y = y+1;
            break;
        case 2:
            caballito.setFila(x+2);
            caballito.setColumna(y-1);
            tablero[x][y] = '-';
            x = x+2;
            y = y-1;
            break;
        case 3:
            caballito.setFila(x-2);
            caballito.setColumna(y+1);
            tablero[x][y] = '-';
            x = x-2;
            y = y+1;
            break;
        case 4:
            caballito.setFila(x-2);
            caballito.setColumna(y-1);
            tablero[x][y] = '-';
            x = x-2;
            y = y-1;
            break;
        case 5:
            caballito.setFila(x+1);
            caballito.setColumna(y+2);
            tablero[x][y] = '-';
            x = x+1;
            y = y+2;
            break;
        case 6:
            caballito.setFila(x+1);
            caballito.setColumna(y-2);
            tablero[x][y] = '-';
            x = x+1;
            y = y-2;
            break;
        case 7:
            caballito.setFila(x-1);
            caballito.setColumna(y+2);
            tablero[x][y] = '-';
            x = x-1;
            y = y+2;
            break;
        case 8:
            caballito.setFila(x-1);
            caballito.setColumna(y-2);
            tablero[x][y] = '-';
            x = x-1;
            y = y-2;
            break;
        default:
            System.out.println("Esto no se debe ver xd");
            break;
        }
    }
    /**
     * Se rellena el tablero de '-' y despues se posiciona el caballo en su nueva posición. Luego se imprime el tablero.
     **/
    public void imprimirPosicionCaballo(){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                tablero[i][j] = '-';
            }
        }	
        tablero[caballito.getFila()][caballito.getColumna()] = 'C';
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero.length; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String [] args){
        Tablero nuestro = new Tablero();
        System.out.println("Movimiento del caballo en el tablero");
        nuestro.inicializarTablero();
        do{
            nuestro.imprimirPosicionCaballo();
            nuestro.calcularPosicion();
            nuestro.moverCaballo();
        }while(true);	
    }
}
