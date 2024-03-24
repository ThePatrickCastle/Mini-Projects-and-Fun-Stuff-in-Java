/**
 * Código que recibie una contraseña y pide verificarla y que tenga algunas condiciones.
 **/
import java.util.Scanner;
public class Verificador extends Exception{
    /**
     * Este código extiende de Exception por flojera de hacer una afuera de este código.
     **/
    public Verificador(String mensaje){
        super(mensaje);
    }   
    /**
     * Metodo verifLongitud. Recibe una cadena a, si su longitud es menor a 8 entonces arrojamos un mensaje que dice que debe ser más larga.
     * @params a La cadena a verificar.
     **/
    public static void verifLongitud(String a) throws Verificador{
        if(a.length()<8){
            throw new Verificador("Tu contraseña debe ser mas larga");
        }
    }
    /**
     * Metodo verifMayuscula. Si la cadena no contiene mayusculas arroja la excepcion.
     * @params a La cadena a verificar.
     **/
    public static void verifMayuscula(String a) throws Verificador{
        boolean mayuscula = false;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i)>=65 && a.charAt(i)<=90){
                mayuscula = true;
                break;
            }
        }
        if(!mayuscula){
            throw new Verificador("Tu contraseña debe tener una mayuscula");
        }
    }
    /**
     * Metodo verifEspeciales. Revisa si alguno de los caracteres dentro de el arreglo especiales se encuentra en la cadena, si no arroja la excepcion.
     * @params a La cadena a verificar.
     **/
    public static void verifEspeciales(String a) throws Verificador{
        char [] especiales = {'.','!','¡','¿','?','#','/',
                              '$','%','=','&',',',':',';','_','-','*',
                              '>','<','+', '@'};
        boolean especial = false;
        for(int j = 0; j<a.length(); j++){
            for(int k = 0; k<especiales.length; k++){
                if(a.charAt(j) == especiales[k]){
                    especial = true;
                    break;
                }
            }
        }	
        if(!especial){
            throw new Verificador("Tu contraseña debe contener al menos un caracter especial");
        }
    }

    /**
     * Método repetircontraseña. Revisa si 2 cadenas son iguales
     * @params a, b Cadenas a verificar si son iguales.
     * @return Falso o Verdadero
     **/
    public static boolean RepetirContraseña(String a, String b){
        if(a.equals(b)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String contraseña = null, comprobador = null;
        boolean bandera, bandera2;
        int contador = 0;
        do{
            try{
                bandera = false;	
                System.out.println("Ingresa una contraseña: ");
                contraseña = sc.nextLine();
                verifLongitud(contraseña);
                verifMayuscula(contraseña);
                verifEspeciales(contraseña);
            } catch(Verificador me){
                System.out.println(me);
                System.out.println("Vuelve a ingresar una contraseña.");
                bandera = true;
            }
        }while(bandera);
        do{
            if(contador == 0){
                System.out.println("Verifica tu contraseña: ");
            }
            else{
                System.out.println("Las contraseñas no coinciden. Intentalo de nuevo");
            }
            comprobador = sc.nextLine();
            bandera2 = RepetirContraseña(contraseña, comprobador);
            contador++;
        }while(!bandera2);
        System.out.println("Contraseña guardada exitosamente");
    }
}
