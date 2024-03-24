/**
 * Esta es una practica de primer semestre, ya esta comentada y la pienso dejar así, aunque me parece muy chistoso como comentaba las cosas en este punto. Una disculpa al lector xd.
 * Practica 6 Excepciones
 * Se implementas 2 métodos principales y 3 secundarios. Este programa pregunta al usuario sobre el nombre, cantidad en existencia y cantidad vendida de productos que guarda en
 * un array de objetos producto con un máximo de 50 objetos disponibles para guardar. Se manejan las excepciones que se solicitaron el la practica, es decir, FormatomayusculasNombreExcepcion,
 * Valormenordeceroexcepcion, Faltapuntoexcepcion y Palabraclaveexcepcion. 
 * @author González Castillo Patricio Salvador
 * @version (5.12.23)
 **/ 
import java.util.Scanner;
public class Actividad1{
    //Creamos un solo objeto de tipo Scanner para los métodos del programa, además de el arreglo y las variables del constructor de "Producto"
    Scanner sc = new Scanner(System.in);
    Producto [] bodega = new Producto[50];
    String nombre_producto, vendidos_producto;
    int unidades_producto;
    //Se divide en 4 secciones el primer "Método principal" que nos permite agregar libros al array de productos
    public void pedirNombre() throws FormatoMayusculasNombreExcepcion{
        System.out.println("Ingresa el nombre del producto que quieres agregar: ");
        nombre_producto = sc.nextLine();
        for(int i = 0; i<nombre_producto.length(); i++){ //En este ciclo recorremos el String que nos da el usuario y verificamos
            //que ningun caracter en el nombre tenga caracteres en minusculas y que 
            //ninguno sea un '/'. En caso de serlo lanzamos la excepcion Formatomayusculasnombreexcepcion
            if(Character.isLowerCase(nombre_producto.charAt(i)) || nombre_producto.charAt(i) == '/'){
                throw new FormatoMayusculasNombreExcepcion("El nombre debe contener solo mayusculas y números. Tampoco puede tener '/'");
            }
        }
    }
    public void pedirExistencia() throws ValorMenorDeCeroExcepcion{
        System.out.println("Ingresa la cantidad de existencia actual de ese producto");
        unidades_producto = sc.nextInt(); //Recibimos el entero que representa las unidades del producto
        sc.nextLine();
        if(unidades_producto < 0){ //En caso de que el usuario ingrese un numero menos a 0 se lanzará la excepcion Valormenordeceroexcepcion
            throw new ValorMenorDeCeroExcepcion("No puede tener existencia negativa");
        }
    }
    public void pedirVentas() throws FaltaPuntoExcepcion{ //En este metodo primero comprobamos que a) La cadena que nos pasa el 
        int contador3 = 0;                                //usuario no sea ninguna letra y b) El caracter final sea un punto
        do{
            System.out.println("¿Cuántos productos ya has vendido?");
            vendidos_producto = sc.nextLine();
            contador3 = 0;
            for(int i = 0; i < vendidos_producto.length(); i++){
                if(Character.isLetter(vendidos_producto.charAt(i))){ //Usamos isLetter para determinar si algun caracter es 
                    contador3++;                                     //una letra en cuyo caso aumentaremos un contador que
                    break;                                           //encierra en un ciclo infinito al usuario hasta que 
                }                                                    //introduzca un numero
            }
            if(contador3 != 0){
                System.out.println("Debes escribir un numero con un punto al final");
            }
        }while(contador3 != 0);
        if(vendidos_producto.charAt(vendidos_producto.length()-1) != '.' || vendidos_producto.charAt(0) == '-'){ //Aqui agregamos que el primer caracter
            throw new FaltaPuntoExcepcion("Debes escribir un numero positivo con un punto al final");            //no puede ser un '-' pues las ventas deben
        }                                                                                                        //positivas
	
    }
    public void agregarProducto(){ //Este es el primer método principal que permite agregar productos al Array
        //Primero verificamos que tengamos espacio en el Arreglo
        int verifica = 0;
        for(int i = 0; i<bodega.length; i++){
            if(bodega[i]==null){ //En caso de encontrar un espacio con valor nulo en el arreglo
                verifica++;      //el contador verifica aumenta y podemos agregar nuevos objetos
                break;
            }
        }	
        if(verifica == 0){ //Si el contador nunca aumentó entonces sabemos que el array está lleno
            System.out.println("Lo sentimos, la bodega ya se llenó de productos");
        }
        else{
            //En caso de poder agregar objetos de manda llamar a los 3 métodos secundarios con sus
            //respectivos bloques try/catch para obligar al usuario a seguir los lineamientos
	    
            //La solucion implementa 3 elementos
            boolean banderin = false; //El primero un booleano que verifica que la excepcion se resuelva, de lo contrario
            do{                       //no permite que el usuario pase a otro proceso del programa
                try{ //El bloque try/catch separa la llamada al metodo y en caso de ser un caso no adecuado tambien imprime el mensaje de la excepcion
                    pedirNombre();
                    banderin = true;
                }catch(FormatoMayusculasNombreExcepcion FMNE){
                    System.out.println(FMNE);
                    banderin = false;
                }
            }while(!banderin);
            //De forma analoga tenemos los metodos de pedirExistencia() y pedirVentas()
            boolean banderin2 = false;
            do{
                try{
                    pedirExistencia();
                    banderin2 = true;
                }catch(ValorMenorDeCeroExcepcion VMCE){
                    System.out.println(VMCE);
                    banderin2 = false;
                }
            }while(!banderin2);
            boolean banderin4 = false;
            do{
                try{
                    pedirVentas();
                    banderin4 = true;
                }catch(FaltaPuntoExcepcion FPE){
                    System.out.println(FPE);
                    banderin4 = false;
                }
            }while(!banderin4);

            //Finalmente instanciamos un nuevo objeto con los valores correctos que indicó el usuario
            Producto nuevo_producto = new Producto(nombre_producto, unidades_producto, vendidos_producto);
            for(int i = 0; i < bodega.length; i++){ //Luego lo colocamos en el primer espacio no nulo
                if(bodega[i] == null){              //del arreglo
                    bodega[i] = nuevo_producto;
                    break;
                }
            }
        }
    }
    
    
    public void mostrarBodega(){ //Este método es la combinacion de 2 métodos secundarios juntos. Primero un algoritmo de ordenamiento
                             	 //BubbleSort y luego un metodo para imprimir todos los objetos Producto del arreglo
        //Este método de ordenamiento lo reutilice de mi practica de los libreros.
        int contador = 0; //El primer paso consiste en encontrar el numero de elementos no nulos de mi arreglo original (bodega)
        for(int i = 0; i <bodega.length; i++){
            if(bodega[i] != null){
                contador++;
            }
        } 
        //Una vez encontrado ese numero creamos un arreglo sin elementos nulos con la longitud de nuestros elementos no nulos
        Producto[] elementosNoNulos = new Producto[contador]; 
        int contador2 = 0;
        for(int i = 0; i < bodega.length; i++) { //Este for nos permite recorrer a la vez el arreglo original (bodega) y mi nuevo arreglo
            if(bodega[i] != null) {              //con el objetivo de rellenar el arreglo de elementos no nulos con los elementos de bodega
                elementosNoNulos[contador2] = bodega[i];
                contador2++;
            }
        }    
        //Implementamos BubbleSort como se vió en la clase
        int n = elementosNoNulos.length-1;	
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(bodega[j].getNombre().compareTo(bodega[j+1].getNombre()) > 0){ //En este caso se nos pidió que se tomara en cuenta toda
                    String auxiliar = bodega[j].getNombre();                      //la palabra para poder ordenar el arreglo. Así uso "compareTo"
                    bodega[j].setNombre(bodega[j+1].getNombre());                 //para obtener un valor numerico de cada palabra en el arreglo y 
                    bodega[j+1].setNombre(auxiliar);                              //usar BubbleSort
                }
            }
        }	
        for(int i = 0; i<bodega.length; i++){ //Eliminamos todos los elementos de nuestro arreglo original
            if(bodega[i] != null){
                bodega[i] = null;
            }
        }
        for(int i = 0; i < contador; i++) { //Rellenamos nuestro arreglo original con los elementos de nuestro arreglo de apoyo.
            bodega[i] = elementosNoNulos[i];
	    
        }
        //Cuando acaba el primer metodo principal, este método lanza un mensaje y imprime los elementos ya ordenados y su posicion
        System.out.println("Tus productos se estan agregando al inventario, a continuación los puesdes consultar en el siguiente listado numerado, ordenados por nombre del producto de manera ascendente:");
        for(int p = 0; p<bodega.length; p++){
            if(bodega[p] != null){
                System.out.println("Posicion "+(p+1));
                System.out.println(bodega[p]);
            }
        }
    }
    
    public static void main(String[]args) throws PalabraClaveExcepcion{ //El método principal arroja la excepcion de palabra clave pues brinda la 
        Actividad1 mia = new Actividad1();                              //condicion de salida para nuestro ciclo principal.
        Scanner teclado = new Scanner(System.in);
        int opc_usuario;
        String respuesta_usuario = "";   //En este caso no se implementa ningun menú intentando apegarme a la ejecucion muestra. Así creo un ciclo principal 
        System.out.println("Inventario");//que inmediatamente ejecuta el primer metodo principal y despues se implementa un bloque try/catch para el segundo 
        do{                              //metodo principal
            mia.agregarProducto();
            boolean banderin3 = false;
            do{
                try{
                    System.out.println("¿Desea agregar otro producto?(responde oui / non)"); 
                    respuesta_usuario = teclado.nextLine();
                    if(!respuesta_usuario.equals("oui") && !respuesta_usuario.equals("non")){ //En caso de que la respuesta no sea ni "si" ni "no" en frances entonces se entra en la excepcion
                        throw new PalabraClaveExcepcion("Debes responder en frances y minusculas"); //El programa es exigente con las letras mayusculas pero se le comunica al usuario en 
                    }                                                                               //dado caso se caiga en la excepcion
                    banderin3 = true;
                }catch(PalabraClaveExcepcion PCE){
                    System.out.println(PCE);
                    banderin3 = false;
                }
            }while(!banderin3);
        }while(!respuesta_usuario.equals("non")); //El programa finaliza si el usuario responde no en frances
        mia.mostrarBodega(); //Una vez finalizado el programa se ejecuta el segundo método principal y se imprime el arreglo con todos los elementos ordenados.
    }
}
