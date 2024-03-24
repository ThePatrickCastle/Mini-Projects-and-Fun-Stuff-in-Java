/**  
 * Perdon por los comentarios así.
 * Proyecto 2 Generar Mano de Cartas                                                    
 * Se genera un arreglo de Cartas asegurandonos de no repetir ninguna, luego se
 * ordenan con base en su valor. Se imprime la mano generada en terminal y despues se
 * realizan diferentes verificaciones para saber el tipo de mano y despues imprimirla.
 * @author González Castillo Patricio Salvador                              
 * @version (12.10.23)                                                      
*/   

import java.util.Random;
public class Actividad1{
    public static void main(String[]args){
	Random rand = new Random();
	int rand_palo;
	int rand_valor;
	char [] opc_palos = {'C','D','T','P'};
	Carta [] mano = new Carta[5];
	//Asignamos valores a la todas las cartas de la mano
	for(int i = 0; i < mano.length; i++){
	    rand_palo = rand.nextInt(3);
	    rand_valor = (int)Math.floor(Math.random() * (13 - 1 + 1) + 1);
	    mano[i] = new Carta(rand_valor, opc_palos[rand_palo]);
	    //Aseguramos que ninguna carta se repite
	    for(int j = 0; j < i; j++){
		if(mano[j].getValor()==mano[i].getValor() && mano[j].getPalo() == mano[i].getPalo()){
		    i--;
		    break;
		}
	    }
	}
	
	//Ordenamos la mano con base en su valor (Implementamos bubble sort)
	int n = mano.length;
	for(int i = 0; i < n - 1; i++){
	    for(int j = 0; j < n - i - 1; j++){
		if(mano[j].getValor() > mano[j + 1].getValor()){
		    Carta temp = mano[j];
		    mano[j] = mano[j + 1];
		    mano[j + 1] = temp;
		}
	    }
	} 

	//Imprimimos la mano generada
	System.out.println("Mano Generada: ");
	for(int j = 0; j < mano.length; j++){
	    System.out.print(mano[j]+" ");
	}
	System.out.println();
	
	//Revisar que tipo de mano es:
	if(mano[0].getValor() == 1 && mano[1].getValor() == 10 && mano[2].getValor() == 11 && mano[3].getValor() == 12 && mano[4].getValor() == 13 && mano[0].getPalo() == mano[1].getPalo() && mano[1].getPalo() == mano[2].getPalo() && mano[2].getPalo() == mano[3].getPalo() && mano[3].getPalo() == mano[4].getPalo()){
	    System.out.println("Escalera Real");
	}
	else if(mano[0].getPalo() == mano[1].getPalo() && mano[1].getPalo() == mano[2].getPalo() && mano[2].getPalo() == mano[3].getPalo() && mano[3].getPalo() == mano[4].getPalo() && mano[1].getValor() == mano[0].getValor()+1 && mano[2].getValor() == mano[1].getValor()+1 && mano[3].getValor() == mano[2].getValor()+1 && mano[4].getValor() == mano[3].getValor()+1){
	    System.out.println("Escalera de Color");
	}
	else if((mano[0].getValor() == mano[1].getValor() && mano[1].getValor() == mano[2].getValor() && mano[2].getValor() == mano[3].getValor()) || (mano[1].getValor() == mano[2].getValor() && mano[2].getValor() == mano[3].getValor() && mano[3].getValor() == mano[4].getValor())){
	    System.out.println("Poker");
	}
	else if((mano[0].getValor() == mano[1].getValor() && mano[1].getValor() == mano[2].getValor() && mano[3].getValor() == mano[4].getValor()) || (mano[0].getValor() == mano[1].getValor() && mano[2].getValor() == mano[3].getValor() && mano[3].getValor() == mano[4].getValor())){
	    System.out.println("Full");
	}
	else if(mano[0].getPalo() == mano[1].getPalo() && mano[1].getPalo() == mano[2].getPalo() && mano[2].getPalo() == mano[3].getPalo() && mano[3].getPalo() == mano[4].getPalo()){
	   System.out.println("Color"); 
	}
	else if(mano[1].getValor() == mano[0].getValor()+1 && mano[2].getValor() == mano[1].getValor()+1 && mano[3].getValor() == mano[2].getValor()+1 && mano[4].getValor() == mano[3].getValor()+1){
	    System.out.println("Escalera");
	}
	else if((mano[0].getValor() == mano[1].getValor() && mano[2].getValor() == mano[3].getValor()) || (mano[0].getValor() == mano[1].getValor() && mano[3].getValor() == mano[4].getValor()) || (mano[1].getValor() == mano[2].getValor() && mano[3].getValor() == mano[4].getValor())){
	    System.out.println("Doble Pareja");
	}
	else if((mano[0].getValor() == mano[1].getValor()) || (mano[1].getValor() == mano[2].getValor()) || (mano[2].getValor() == mano[3].getValor()) || (mano[3].getValor() == mano[4].getValor())){
	    System.out.println("Pareja");
	}
	else{
	    System.out.println("Esa es una mala mano.");
	}


    }
}
