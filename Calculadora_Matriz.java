/**
 * Clase que calcula todo tipo de operaciones con matrices. Simplemente para saber como manipularlas, no con las mejores practicas, pero sirve como introducción.
 **/
import java.util.Scanner;
public class Calculadora_Matriz{
    /**
     * Metodo que devuelve un pide por algun dato, ya sea fila y columna y lo devuelve.
     **/
    public static int filaColumna() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }
    /**
     * Metodo crearMatriz. Recibe 2 entradas y crea una matriz con esos parametros.
     * @params i, j Valores que se agregaran a la matriz
     * @return matriz Inicializada con los valores i, j
     **/
    public static int[][] crearMatriz(int i, int j) {
        int[][] matriz = new int[i][j];
        return matriz;
    }
    /**
     * Metodo ingresardatos. Permite al usuario rellenar cada uno espacios de la matriz con sus valores.
     * @params matriz La matriz a rellenar
     **/
    public static void ingresarDatos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Elemento[" + i + "][" + j + "] = ");
                matriz[i][j] = filaColumna();
            }
        }
    }
    /**
     * Metodo mostrarmatriz. Imprime cada elemento de la matriz
     * @params matriz La matriz a imprimir
     **/
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * Metodo sumamatrices. Permite al usuario sumar 2 matrices 
     * @params a, b Matrices que se sumaran
     * @return c La matriz resultante de A + B
     **/
    public static int[][] sumaMatrices(int[][] a, int[][] b) {
        int[][] c = crearMatriz(a.length, a[0].length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
    /**
     * Metodo restamatrices. Permite al usuario restar 2 matrices
     * @params a, b Las matrices a restar
     * @return c La matriz resultante de A - B
     **/
    public static int[][] restaMatrices(int[][] a, int[][] b) {
        int[][] c = crearMatriz(a.length, a[0].length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }
    /**
     * Metodo transpuestamatriz. En una matriz diferente intercambia los valores (excepto los de la diagonal) por sus valores en fila columna, columna fila.
     * @params matriz La matriz a la que le calcularemos la transpuesta
     * @return C La transpuesta de A
     **/
    public static int [][] transpuestaMatriz(int [][] a){
        int[][] c = crearMatriz(a.length, a[0].length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[j][i];
            }
        }
        return c;
    }
    /**
     * Metodo multiplicacion2x2. Es una version a fuerzza bruta de lo que es la multiplicación de matrices 2x2. No encontrar un modelo matemático
     * @params a, b Las matrices de 2x2 que multiplicaremos
     * @return C el resultado de  hacer A*B
     **/
    public static int [][] multiplicacion2x2(int [][] a, int [][] b){
        int[][] c = crearMatriz(a.length, a[0].length);
        c [0][0] = (a[0][0] * b[0][0]) + (b[1][0] * a[0][1]);
        c [0][1] = (a[0][0] * b[0][1]) + (b[1][1] * a[0][1]);
        c [1][0] = (a[1][0] * b[0][0]) + (b[1][0] * a[1][1]);
        c [1][1] = (a[1][0] * b[0][1]) + (b[1][1] * a[1][1]);
        return c;
    }
 

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opc_usuario;
        System.out.println("Calculadora de Matrices");
        System.out.println("Elige tu opcion");
        do{
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar 2x2");
            System.out.println("4. Calcular Matriz Transpuesta");
            opc_usuario = teclado.nextInt();
        }while (opc_usuario < 0 || opc_usuario > 4);
	
        if(opc_usuario == 1 || opc_usuario == 2 || opc_usuario == 3){
            int filas;
            int columnas;
            do {
                System.out.print("Número de filas: ");
                filas = filaColumna();
            } while (filas < 1);
            do {
                System.out.print("Número de columnas: ");
                columnas = filaColumna();
            } while (columnas < 1);
            int[][] A = crearMatriz(filas, columnas);
            int[][] B = crearMatriz(filas, columnas);
	    
            System.out.println("Matriz A:");
            ingresarDatos(A);
            System.out.println("Matriz B:");
            ingresarDatos(B);
	    
            switch(opc_usuario){
            case 1:
                int[][] C = sumaMatrices(A, B);
                System.out.println("matriz A:");
                mostrarMatriz(A);
                System.out.println("\nmatriz B:");
                mostrarMatriz(B);
                System.out.println("\nmatriz Suma:");
                mostrarMatriz(C);
                break;
            case 2:
                int[][] E = restaMatrices(A, B);
                System.out.println("matriz A:");
                mostrarMatriz(A);
                System.out.println("\nmatriz B:");
                mostrarMatriz(B);
                System.out.println("\nmatriz Resta:");
                mostrarMatriz(E);
                break;
            case 3:
                int[][] M = multiplicacion2x2(A, B);
                System.out.println("matriz A:");
                mostrarMatriz(A);
                System.out.println("\nmatriz B:");
                mostrarMatriz(B);
                System.out.println("\nmatriz Multiplicacion:");
                mostrarMatriz(M);
                break;
            }
        }
        else{
            //calcular transpuesta
            int filas;
            int columnas;
            System.out.println("Matriz A:");
            do {
                System.out.print("Número de filas: ");
                filas = filaColumna();
            } while (filas < 1);
            do {
                System.out.print("Número de columnas: ");
                columnas = filaColumna();
            } while (columnas < 1);
            int[][] A = crearMatriz(filas, columnas);
            ingresarDatos(A); 
            System.out.println("matriz A:");
            mostrarMatriz(A);
            int[][] C = transpuestaMatriz(A);
            System.out.println("\nmatriz Transpuesta:");
            mostrarMatriz(C);   
        }	
    }
}
