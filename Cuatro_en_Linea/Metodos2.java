/**
 * La forma en la que comento es horrible, pero la dejo como recuerdo. Disculpas al lector.
 * Proyecto 3 Metodos 2
 * Esta clase tiene todos los metodos que se utilizan en la actividad 2 para que sea funcional
 * @author González Castillo Patricio Salvador
 * @version (14.12.23)
 */ 
import java.util.Random;
import java.util.Scanner;
public class Metodos2{
    // Como variables globales tenemos un objeto Scanner
    Scanner teclado = new Scanner(System.in);
    int no_fila = 0; // El numero de columnas, pero me di cuenta muy tarde que lo puse mal, entonces así lo deje.
    char simbolo = 'O'; // El simbolo es la ficha que va a cambiar dependiendo el turno de la maquina o del usuario
    
    public void crearJuego(char [][] juego){
	// Para inicializar los valores de la matriz primero inicializamos una variable con el valor del 
	// codigo ASCII para la letra 'A'. Así podemos reyenar la ultima fila con las letras de A a G
	int a = 65;
	for(int i = 0; i < juego.length; i++){
	    for(int j = 0; j < juego[0].length; j++){
		if(i == 6){
		    juego[i][j] = (char)a; // Primero casteamos el valor de a y lo aumentamos para la siguiente iteracion
		    a++;
		}
		else{
		    juego[i][j] = '-'; // Si no estamos en la ultima fila entonces rellenamos con guiones
		}
	    }
	}
    }

    public void imprimirJuego(char [][] juego){ // recorremos el arreglo y lo imprimimos en cada posicion
	for(int i = 0; i < juego.length; i++){
	    for(int j = 0; j < juego[0].length; j++){
		System.out.print(juego[i][j]);
	    }
	    System.out.println();
	}
    }




    // Este metodo se encarga de revisar una condicion del juego y es que si se llena el tablero
    // y no se ha encontrado ninguna forma de los 4 conectados entonces el juego es un empate 
    // y se le avisa al usuario
    public boolean verificarTablero(char [][] juego){ // Es un metodo booleano que regresa verdadeso solo cuando puede entontrar '-'
	for(int i = 0; i < juego.length; i++){
	    for(int j = 0; j < juego[0].length; j++){
	        if(juego[i][j] == '-'){
		    return true;
		}
	    }
	}
	System.out.println("El juego se llenó, es un empate");
	return false;
    }
    


    // Metodo para que el usuario ingrese una fila se le solicita un caracter en mayusculas y el simbolo se selecciona como las 'X'
    public void turnoUsuario(){
	String mi_opc;
	char opc_usuario;
	no_fila = -1; // Inicializamos no_fila en -1 para asegurarnos que el valor 0 sea considerado para el indice 0 del arreglo.
	simbolo = 'X';
	System.out.println("Turno Usuario");
	System.out.println("Escoge una columna para tu ficha (de la A a la G)");
	// Este ciclo nos asegura que el usuario va a elegir un valor de los especificados en el switch, de lo contrario se le lanzara un mensaje
	// pidiendo un valor valido. Segun la letra que nos de el usuario nosotros vamos a asignar un valor a la columna en la que queramos ingresar
	// el turno
	do{
	    // <-- Correción. Me aseguro que el usuario no pueda introducir más de una letra
	    do{
		mi_opc = teclado.nextLine();
		opc_usuario = mi_opc.charAt(0);
		if(mi_opc.length() != 1){
		    System.out.println("No puedes ingresar mas de una letra");
		}
	    }while(mi_opc.length() != 1);
	    
	    switch(opc_usuario){
	    case 'A':
		no_fila = 0;
		break;
	    case 'B':
		no_fila = 1;
		break;
	    case 'C':
		no_fila = 2; 
		break;
	    case 'D':
		no_fila = 3;
		break;
	    case 'E':
		no_fila = 4;
		break;
	    case 'F':
		no_fila = 5;
		break;
	    case 'G':
		no_fila = 6;
		break;
	    default:
		System.out.println("Ingresa una fila válida");
		break;
	    }
	}while(no_fila == -1);
	
    }

    //Para el turno de la computadora solo necesitamos que eliga un numero aleatorio entre el 0 y el 6 (los indices de la matriz)
    // y cambiar el simbolo a 'Y'
    public void turnoComputadora(){
	Random rn = new Random();
	simbolo = 'Y';
	System.out.println("Turno Computadora");
	no_fila = rn.nextInt(6 - 0 + 1) + 0;
    }
    
    // Metodo para  colocar la ficha. Solo necesitamos recordar que la ultima fila del arreglo no es valida para jugar
    // así nuestra variable juegoMenosABC lo que nos indica es la altura "jugable" de nuestro arreglo
    public void colocarFicha(char [][] juego){ 
	int juegoMenosABC = juego.length-1;
	// Para determinar en que fila debe estar nuestra ficha debemos primero asegurarnos de que 
	// la ficha que esta justo abajo de la posicion evaluada no sea un guion bajo porque de lo
	// contrario la ficha podría quedar flotante
	while(juegoMenosABC >= 0 && juego[juegoMenosABC][no_fila] != '-'){
	    juegoMenosABC--;
	}
	// Si conseguimos que la fila en la que queremos poner la ficha sea válida (es decir tenga una letra abajo y sea un '-')
	// entonces colocamos el simbolo en esa posicion
	if(juegoMenosABC >= 0){
	    juego[juegoMenosABC][no_fila] = simbolo;
	}
	// Para solucionar el problema de que alquien quiera poner algo en una columna llena
	// no asignamos ninguna ficha a su turno y le informamos que perdió el turno
	else{
	    System.out.println("Perdiste el turno, ya no puedes poner fichas en esa fila");
	}
    }

    // Se implementa el mismo metodo de busqueda de la Actividad1

    // Recibimos el arreglo con las letras de la palabra a encontrar y las coordenadas son la posicion en la que estamos
    // (los valores de de la iteracion del ciclo principal)
    public boolean buscarPalabraHorizontal(char [][] juego, char[] palabra, int x, int y){
	for(int i = 0; i < palabra.length; i++){
	    // Para desplazarnos debemos iterar sobre el arreglo palabra y modificar los valores de la iteracion principal. En este caso queremos que el valor i
	    // avance si problemas, así solo lo multiplicamos por 1 para poder acercarnos progresivamente hacia la derecha
	    // No queremos desplazarnos en las columnas, así eliminamos el valor de la iteracion de la palabra manteniendonos en el unico indice y de la palabra
	    int banderaenX = x + i*1;
	    int banderaenY = y + i*0;
	    // En caso de que estemos iterando sobre algun valor no disponible en la matriz el resultado de nuestra busqueda será invalido ya sea en el indice i o j de la iteracion principal
	    // además ahora si comparamos el indice de nuestra palabra con el indice de la iteracion en nuestra matriz, que se recorre junto con el indice de la palabra, si no hay coincidencias,
	    // por cada elemento en la matriz, el metodo regresará false. De lo contrario regresa true.
	    if(banderaenX < 0 || banderaenX >= juego.length || banderaenY < 0 || banderaenY >= juego[0].length || juego[banderaenX][banderaenY] != palabra[i]){
		return false;
	    }
	}
	return true;
    }      
    public boolean buscarPalabraVertical(char [][] juego, char[] palabra, int x, int y){
	for(int i = 0; i < palabra.length; i++){
	    //Para buscar en vertical es una idea similar pero ahora queremos que no se mueva nuestro indice en las columnas por eso se multiplica por 0.
	    // en cambio ahora si nos importa el indice en el que itera sobre las filas, mientras la columna se queda estática
	    int banderaenX = x + i*0;
	    int banderaenY = y + i*1;
	    // Análogamente si se esta iterando sobre un index no existente o no hay coincidencia entre la palabra y la matriz el método regresa false.
	    if(banderaenX < 0 || banderaenX >= juego.length || banderaenY < 0 || banderaenY >= juego[0].length || juego[banderaenX][banderaenY] != palabra[i]){
		return false;
	    }
	}
	return true;
    }    
    public boolean buscarPalabraDiagonalDerecha(char [][] juego, char[] palabra, int x, int y){
	for(int i = 0; i < palabra.length; i++){
	    // Ahora se multiplica de tal forma que se aumenten ambos indices de forma simultanea creando un recorrido en diagonal
	    // el unico problema es la eficiencia del metodo pues para casi todos los elementos el resultado será falso por que no
	    // tienen una posicion con la suficiente longitud para si quiera comparar los indices con la palabra (en las esquinas)
	    int banderaenX = x + i*1;
	    int banderaenY = y + i*1;
	    if(banderaenX < 0 || banderaenX >= juego.length || banderaenY < 0 || banderaenY >= juego[0].length || juego[banderaenX][banderaenY] != palabra[i]){
		return false;
	    }
	}
	return true;
    }    
    public boolean buscarPalabraDiagonalIzquierda(char [][] juego, char[] palabra, int x, int y){
	for(int i = 0; i < palabra.length; i++){
	    // Cuando transformamos el segundo indice en negativo hacemos que la eficiencia en los indices bajos de x baje
	    // pues ninguno de los primeros elementos en la matriz tienen suficiente longitud contra la palabra pero fuera de eso
	    // cuando toca revisar las esquinas superiores derechas el metodo recorre todos las diagonales "positivas"
	    int banderaenX = x + i*1;
	    int banderaenY = y + i*-1;
	    if(banderaenX < 0 || banderaenX >= juego.length || banderaenY < 0 || banderaenY >= juego[0].length || juego[banderaenX][banderaenY] != palabra[i]){
		return false;
	    }
	}
	return true;
    }
    

    // Para buscar el código se cambió el código de la Actividad 1 para convertir el metodo en una condicion de cierre en el juego.

    public boolean buscarEnJuego(char [][] juego, char[] palabra){	
	for(int i = 0; i < juego.length; i++){
	    for(int j = 0; j < juego[0].length; j++){
		// Se busca la palabra de acuerdo a su posicion (horizontal, vertical, y ambas diagonales)
		if(buscarPalabraHorizontal(juego, palabra, i, j) || buscarPalabraVertical(juego, palabra, i, j) || 
		   buscarPalabraDiagonalDerecha(juego, palabra, i, j) || buscarPalabraDiagonalIzquierda (juego, palabra, i, j)){
		    // Dependiendo del simbolo del jugador que se este verificando se lanzará el mensaje del ganador
		    if(palabra[0] == 'X'){
			System.out.println("El jugador humano ha ganado");
			return true; // Además se cambia el estado de la busqueda a verdadero
		    }
		    else{
			System.out.println("La maquina ha ganado");
			return true;
		    }
		}
	    }
	}
	return false;
    }  
}
