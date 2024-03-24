/**
 * Calculadora de Segundo Grado. Esta calculadora es una chicharronera automatizada.
 **/
import java.util.Scanner;
public class Calcu_SegundoGrado{    
    public static void main(String[]args){
        double a, b, c, sec_1, x1, x2, paso_intermedio;
        Scanner teclado = new Scanner(System.in);
        /**
         * El usuario ingresa sus valores, se realizan unas verificaciones y se imprime el resultado.
         **/
        System.out.println("Calculadora de Ecuaciones de Segundo Grado");
        System.out.println("Ingrese los valores:");
        System.out.println("a =");
        a = teclado.nextDouble();
        if(a == 0){
            System.out.println("Su ecuación no es de segundo grado");
        }
        else{
            System.out.println("b =");
            b = teclado.nextDouble();
            System.out.println("c =");
            c = teclado.nextDouble();
	    
            sec_1 = Math.pow(b,2)-(4*a*c);
            x1 = ((b*(-1))+Math.sqrt(sec_1))/(2*a);
            x2 = ((b*(-1))-Math.sqrt(sec_1))/(2*a);
	    
            if(sec_1>=0){
                System.out.println("Los resultados de su ecuación son:");
                System.out.println("x1 = "+ x1);
                System.out.println("x2 = "+ x2);
            }
            else{
		
                sec_1 = (Math.sqrt(-1*(Math.pow(b,2)-(4*a*c))))/(2*a);
                paso_intermedio = (b*(-1))/(2*a);
	        
                System.out.println("x1 = "+paso_intermedio+" + i "+sec_1);
                System.out.println("x2 = "+paso_intermedio+" - i "+sec_1);
            }
        }
    }
}
