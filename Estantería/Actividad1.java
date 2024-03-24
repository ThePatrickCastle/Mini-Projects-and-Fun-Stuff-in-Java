/**
 * Perdon por la forma de comentar la practica.
 * Practica 4 Estanteria
 * Se implementas 7 métodos para guardar, buscar borrar y modificar libros, además acomodar, ordenar y eliminar una biblioteca implementada como 
 * @author González Castillo Patricio Salvador
 * @version (12.10.23)
 **/

import java.util.Scanner;
public class Actividad1{
    Libro [] librero = new Libro[10]; //Se crea un arreglo con capacidad de 10 elementos de tipo libro
    //Metodo para guardar un libro
    public void agregarLibro(){
        int verifica;
        Scanner teclado = new Scanner(System.in);
        verifica = 0;
        //Verificamos que exista un lugar en el arreglo librero
        //Si existe se procede con el metodo, si no se le notifica al usuario
        for(int i = 0; i<librero.length; i++){
            if(librero[i]==null){
                verifica++;
                break;
            }
        }	
        if(verifica == 0){
            System.out.println("Librero Lleno. No se pueden agregar libros");
        }
        else{
            int verif_libro_infantil, apellido_conoce;
            int isbn, impresion, paginas, ilustraciones = 0;
            String titulo, editorial, genero;
            String nombre_Autor, apellidoPat_Autor, apellidoMat_Autor, nacionalidad_Autor;
            Autor nuevo_autor = new Autor("","","",""); //Inicializamos al autor con valores "vacíos"
            //así evitamos problemas con el constructor aunque
            //en la clase Autor contamos con ambos constructores
	    
            //Pedimos primero los datos del autor
            System.out.println("-----------------Datos del Autor-----------------");
            System.out.println("Nombre:");
            nombre_Autor = teclado.nextLine();
            nuevo_autor.setNombre(nombre_Autor);
            System.out.println("Apellido Paterno:");
            apellidoPat_Autor = teclado.nextLine();
            nuevo_autor.setApellidoPat(apellidoPat_Autor);
            System.out.println("Nacionalidad");
            nacionalidad_Autor = teclado.nextLine();
            nuevo_autor.setNacionalidad(nacionalidad_Autor);
            System.out.println("Conoce el apellido materno?");
            System.out.println("1. Si");
            System.out.println("2. No");
            apellido_conoce = teclado.nextInt();
            //Si el apellido materno no se conoce, se queda como ya inicializado.
            if(apellido_conoce == 1){
                System.out.println("Apellido Materno:");
                teclado.nextLine();
                apellidoMat_Autor = teclado.nextLine();
                nuevo_autor.setApellidoMat(apellidoMat_Autor);
            }
            //Se realizan verificaciones sobre los datos del libro: Año de Impresion, 
            //Numero de Paginas y Ilustraciones para los libros infantiles
            System.out.println("-----------------Datos del Libro-----------------");
            System.out.println("¿Es un libro infantil?");
            System.out.println("1. Si");
            System.out.println("2. No");
            verif_libro_infantil = teclado.nextInt();
            System.out.println("Informacion del Libro:");
            do{
                System.out.println("ISBN (International Standard Book Number):");
                isbn = teclado.nextInt();
                if(isbn < 0){
                    System.out.println("ISBN inválido. Ingrese otro ISBN");
                }
            }while(isbn < 0);
            System.out.println("Titulo:");
            teclado.nextLine();
            titulo = teclado.nextLine().toUpperCase();
            System.out.println("Editorial:");
            editorial = teclado.nextLine();
            System.out.println("Genero:");
            genero = teclado.nextLine();
            do{
                System.out.println("Año de Impresion:");
                impresion = teclado.nextInt();
                if(impresion < 0){
                    System.out.println("Ingrese un año válido");
                }
            }while(impresion < 0);
            if(verif_libro_infantil == 1){
                do{
                    System.out.println("Numero de Paginas: ");
                    paginas = teclado.nextInt();
                    if(paginas < 0 || paginas > 30){
                        System.out.println("Numero de paginas invalido para un libro infantil");
                    }
                }while(paginas > 30 || paginas < 0);
            }
            else{
                do{
                    System.out.println("Numero de Paginas: ");
                    paginas = teclado.nextInt();
                    if(paginas < 0){
                        System.out.println("El numero de paginas no puede ser negativo. Ingrese un numero de paginas valido");
                    }
                }while(paginas < 0);
            }
            do{
                System.out.println("No. de Ilustraciones: ");
                ilustraciones = teclado.nextInt();	  
                if(ilustraciones < 0){
                    System.out.println("El numero de ilustraciones es invalido");
                }
            }while(ilustraciones < 0);
            //Aqui verificamos que no exista un libro con un ISBN igual a otro ya existente en el array. 
            //Si no existe se guarda, de lo contrario al usuario se le informa que no puede guardar su libro.
            boolean verifISBN = true;
            for(int i = 0; i < librero.length; i++){
                if(librero[i] != null){
                    if(librero[i].getISBN() == isbn){
                        verifISBN = false;
                        break;
                    }
                }
            }
            if(verifISBN){
                if(verif_libro_infantil == 1){
                    LibroInfantil nuevo_libro = new LibroInfantil(isbn, titulo, nuevo_autor, editorial,  genero, impresion, paginas, true, ilustraciones);
                    for(int i = 0; i < librero.length; i++){
                        if(librero[i] == null){
                            librero[i] = nuevo_libro;
                            break;
                        }
                    }
                }
                else{
                    Libro nuevo_libro = new Libro(isbn, titulo, nuevo_autor, editorial, genero, impresion, paginas);
                    for(int i = 0; i < librero.length; i++){
                        if(librero[i] == null){
                            librero[i] = nuevo_libro;
                            break;
                        }
                    }
                }
            }
            else{
                System.out.println("Ya existe un libro con ISBN: "+isbn+". No se ha guardado el libro.");
            }
        }	
    }

    //Metodo para buscar libros
    public void buscarLibro(){
        int opc_busqueda, contador_coincidencias = 0, apellido_conoce;
        Autor buscado = new Autor("","","","");
        String nombre_Autor, apellidoPat_Autor, apellidoMat_Autor, nacionalidad_Autor, titulo_buscado, genero_buscado;
        Scanner teclado3 = new Scanner(System.in);
        //Implementamos la busqueda sobre los 3 casos: Autor, Titulo o Genero 
        //Para el autor se piden los datos del autor buscado y luego se recorre el arreglo para encontrar alguna coincidencia.
        //Tanto para el genero como el titulo, se compara el string del usuario con el get respectivo de cada atributo.
        //Si se encuentra alguna coincidencia se aumenta un contador y se imprimen en pantalla los libros que cuenten con al menos 
        //un entrada coincidente
        System.out.println("Buscar libro por:");
        System.out.println("1. Autor");
        System.out.println("2. Titulo");
        System.out.println("3. Genero");
        opc_busqueda = teclado3.nextInt();
        switch(opc_busqueda){
        case 1:
            System.out.println("Ingrese los datos del autor");
            System.out.println("Nombre:");
            teclado3.nextLine();
            nombre_Autor = teclado3.nextLine();
            buscado.setNombre(nombre_Autor);
            System.out.println("Apellido Paterno:");
            apellidoPat_Autor = teclado3.nextLine();
            buscado.setApellidoPat(apellidoPat_Autor);
            System.out.println("Nacionalidad");
            nacionalidad_Autor = teclado3.nextLine();
            buscado.setNacionalidad(nacionalidad_Autor);
            System.out.println("Conoce el apellido materno?");
            System.out.println("1. Si");
            System.out.println("2. No");
            apellido_conoce = teclado3.nextInt();
            if(apellido_conoce == 1){
                System.out.println("Apellido Materno:");
                teclado3.nextLine();
                apellidoMat_Autor = teclado3.nextLine();
                buscado.setApellidoMat(apellidoMat_Autor);
            } 
            System.out.println("Coincidencias: ");
            for(int i = 0; i < librero.length; i++){
                if(librero[i] != null){
                    String nombre_actual = librero[i].getAutor().getNombre();
                    String apellidoPat_actual = librero[i].getAutor().getApellidoPat();
                    String apellidoMat_actual = librero[i].getAutor().getApellidoMat();
                    String nacionalidad_actual = librero[i].getAutor().getNacionalidad();

                    String nombre_buscado = buscado.getNombre();
                    String apellidoPat_buscado = buscado.getApellidoPat();
                    String apellidoMat_buscado = buscado.getApellidoMat();
                    String nacionalidad_buscado = buscado.getNacionalidad();
                    if(nombre_actual.equals(nombre_buscado) || apellidoMat_actual.equals(apellidoMat_buscado) || apellidoPat_actual.equals(apellidoPat_buscado) || nacionalidad_actual.equals(nacionalidad_buscado)){
                        contador_coincidencias++;
                        System.out.println(contador_coincidencias+". "+librero[i]);
                    }
                }
            }
            if(contador_coincidencias == 0){
                System.out.println("No hay coincidencias");
            }
            break;
        case 2:
            System.out.println("Ingrese el titulo de su libro:");
            teclado3.nextLine();
            titulo_buscado = teclado3.nextLine();
            System.out.println("Coincidencias: ");
            for(int i = 0; i < librero.length; i++){
                if(librero[i] != null){
                    String titulo_actual = librero[i].getTitulo();
                    if(titulo_buscado.equals(titulo_actual)){
                        contador_coincidencias++;
                        System.out.println(contador_coincidencias+". "+librero[i]);
                    }
                }
            }    
            break;
        case 3:
            System.out.println("Ingrese el genero de su libro:");
            teclado3.nextLine();
            genero_buscado = teclado3.nextLine();
            System.out.println("Coincidencias: ");
            for(int i = 0; i < librero.length; i++){
                if(librero[i] != null){
                    String genero_actual = librero[i].getGenero();
                    if(genero_buscado.equals(genero_actual)){
                        contador_coincidencias++;
                        System.out.println(contador_coincidencias+". "+librero[i]);
                    }
                }
            }        
            break;
        default:
            System.out.println("Este mensaje no se debe ver");
            break;
        }
    }

    //Metodo para Borrar un libro
    //Este metodo comprueba primero la existencia de un Libro en el arreglo con el ISBN igual a la entrada del usuario
    //Si esto se cumple se imprime el mensaje de libro eliminado y se declara el espacio en el arreglo del libro null.
    //Si no se cumple se le informa al usuario que no existe libro con tal ISBN
    public void eliminarLibro(){
        int usuario_isbn, identificador = 0;
        Scanner teclado2 = new Scanner(System.in);
        System.out.println("Ingresa el ISBN del libro que desea eliminar: ");
        usuario_isbn = teclado2.nextInt();
        for(int i = 0; i < librero.length; i++){
            if(librero[i] != null){
                int isbn_actual = librero[i].getISBN();
                if(isbn_actual == usuario_isbn){
                    System.out.println("Libro Localizado");
                    System.out.println("Libro Eliminado");
                    librero[i] = null;
                    identificador = 1;
                }
            }
        }
        if(identificador == 0){
            System.out.println("El libro con identificador: "+usuario_isbn+" no ha sido localizado");
        }
    }

    //Metodo para modificar libro
    //Tiene una estructura similar al metodo para inresar un libro, solo que esta vez solo se pide el atributo que se elija en el menu.
    //Esto se implemento con un switch, y para el caso especial del atributo Autor, se tiene un switch anidado con la misma estructura.
    public void modificarLibro(){
        int isbn_buscado, edicion_opc_usuario, edicion_opc_autor;
        String nuevo_titulo, nueva_editorial, nuevo_genero;
        int nuevo_añoImpresion, nuevo_noPaginas;
        String nuevo_nombre, nuevo_apePat, nuevo_apeMat, nueva_Nacionalidad;
        Scanner teclado4 = new Scanner(System.in);
        System.out.println("Ingrese el ISBN del libro que desea modificar: ");
        isbn_buscado = teclado4.nextInt();
        for(int i = 0; i<librero.length; i++){
            if(librero[i] != null){
                if(librero[i].getISBN() == isbn_buscado){
                    System.out.println("Libro Localizado");
                    System.out.println("Edicion de titulo: "+isbn_buscado);
                    do{
                        System.out.println("Elija una opcion:");
                        System.out.println("1. Titulo");
                        System.out.println("2. Autor");
                        System.out.println("3. Editorial");
                        System.out.println("4. Genero");
                        System.out.println("5. Año de Impresion");
                        System.out.println("6. Numero de Paginas");
                        System.out.println("7. Salir");	
                        edicion_opc_usuario = teclado4.nextInt();

                        switch(edicion_opc_usuario){
                        case 1:
                            System.out.println("Ingrese el nuevo titulo");
                            teclado4.nextLine();
                            nuevo_titulo = teclado4.nextLine().toUpperCase();
                            librero[i].setTitulo(nuevo_titulo);
                            break;
                        case 2:
                            System.out.println("Edicion de Autor. Libro: "+isbn_buscado);
                            do{
                                System.out.println("Elija una opcion:");
                                System.out.println("1. Nombre");
                                System.out.println("2. Apellido Paterno");
                                System.out.println("3. Apellido Materno");
                                System.out.println("4. Nacionalidad");
                                System.out.println("5. Salir");
                                edicion_opc_autor = teclado4.nextInt();
                                switch(edicion_opc_autor){
                                case 1:
                                    System.out.println("Ingrese el nuevo nombre");
                                    teclado4.nextLine();
                                    nuevo_nombre = teclado4.nextLine();
                                    librero[i].getAutor().setNombre(nuevo_nombre);
                                    break;
                                case 2:
                                    System.out.println("Ingrese el nuevo apellido paterno");
                                    teclado4.nextLine();
                                    nuevo_apePat = teclado4.nextLine();
                                    librero[i].getAutor().setApellidoPat(nuevo_apePat);
                                    break;
                                case 3:
                                    System.out.println("Ingrese el nuevo apellido materno");
                                    teclado4.nextLine();
                                    nuevo_apeMat = teclado4.nextLine();
                                    librero[i].getAutor().setApellidoMat(nuevo_apeMat);
                                    break;
                                case 4:
                                    System.out.println("Ingrese la nueva nacionalidad");
                                    teclado4.nextLine();
                                    nueva_Nacionalidad = teclado4.nextLine();
                                    librero[i].getAutor().setNacionalidad(nueva_Nacionalidad);
                                    break;
                                case 5:
                                    System.out.println("Volviendo al menu de edicion...");
                                    break;
                                default:
                                    System.out.println("Este mensaje no se deberia ver");
                                    break;
                                }   
                            }while(edicion_opc_autor != 5);

	
                            break;
                        case 3:
                            System.out.println("Ingrese la nueva editorial");
                            teclado4.nextLine();
                            nueva_editorial = teclado4.nextLine();
                            librero[i].setEditorial(nueva_editorial);
                            break;
                        case 4:
                            System.out.println("Ingrese el nuevo genero");
                            teclado4.nextLine();
                            nuevo_genero = teclado4.nextLine();
                            librero[i].setGenero(nuevo_genero);
                            break;
                        case 5:
                            do{
                                System.out.println("Ingrese el nuevo año de impresion");
                                nuevo_añoImpresion = teclado4.nextInt();
                                if(nuevo_añoImpresion < 0){
                                    System.out.println("El año ingresado es invalido. Pruebe nuevamente");
                                }
                            }while(nuevo_añoImpresion < 0);
                            librero[i].setAñoImpresion(nuevo_añoImpresion);
                            break;
                        case 6:
                            do{
                                System.out.println("Ingrese el nuevo numero de paginas");
                                nuevo_noPaginas = teclado4.nextInt();
                                if(nuevo_noPaginas < 0){
                                    System.out.println("Numero de paginas inválido. Pruebe nuevamente");
                                }
                            }while(nuevo_noPaginas < 0);
                            librero[i].setNoPaginas(nuevo_noPaginas);
                            break;
                        case 7:
                            System.out.println("Regresando al menu...");
                            break;
                        default:
                            System.out.println("Este mensaje no debe aparecer");
                            break;
                        }

                    }while(edicion_opc_usuario != 7);
                    break;
                }
            }
        }
    }

    //Metodo para imprimir biblioteca
    // Habian 2 formas de implementar este metodo, una opcion era solo imprimir los libros en el librero que fueran no vacíos
    // pero me decidí por imprimir los espacios disponibles para que el usuario pueda estar al tanto de los espacios vacíos y 
    // como se mueven los libros para el metodo ordenarLibrero y eliminarlibro.
    public void imprimirLibrero(){
        for(int i = 0; i<librero.length; i++){
            if(librero[i] != null){
                System.out.println("Posicion "+(i+1));
                System.out.println(librero[i]);
            }
            else{
                System.out.println("Espacio "+(i+1)+" Disponible");
            }
        }
    }

    //Metodo para Ordenar Biblioteca
    public void ordenarLibrero(){
        //Primero queremos contar el numero de elementos no nulos en nuestro array librero
        int contador = 0;
        for(int i = 0; i <librero.length; i++){
            if(librero[i] != null){
                contador++;
            }
        }  
        // Con base en ese contador creamos un nuevo arreglo con exactamente el numero de espacios correspondientes
        // al numero de libros en el librero.
        Libro[] elementosNoNulos = new Libro[contador]; 
        int contador2 = 0; //Este contador nos permite iterar al mismo tiempo sobre todos los elementos de librero y
        // cambiar la posicion de nuestro arreglo original cuando se encuentra con un elemento no nulo. 
        // Es decir rellenamos a nuestro arreglo secundario con los elementos de librero.
        for(int i = 0; i < librero.length; i++) {
            if(librero[i] != null) {
                elementosNoNulos[contador2] = librero[i];
                contador2++;
            }
        }    
        // Esta es la implementacion de bubble sort sobre el primer char de el titulo de los elementos de librero. 
        // Esta es una alternativa a castear ese char a entero. Con un unico problema de que el codigo unicode nos arroja 
        // primero todas las mayusculas y luego las minusculas. Es decir puede suceder esto: A, B, C, D, a con los elementos
        // ya ordenados. La solucion es castear estos elementos a mayusculas para el intercambio o en general para todo nombre.
        int n = elementosNoNulos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elementosNoNulos[j].getTitulo().charAt(0) > elementosNoNulos[j + 1].getTitulo().charAt(0)) {
                    Libro temp = elementosNoNulos[j];
                    elementosNoNulos[j] = elementosNoNulos[j + 1];
                    elementosNoNulos[j + 1] = temp;
                }
            }
        }
        // Vaciamos nuestro arreglo original. Esto con el proposito de evitar que si se borraron previo al ordenamiento algunos libros, estos se recorran y nombre
        // se den casos en los que un libro que estuviera en la posicion 3 pero con la posicion 2 vacía, se ordenara y por lo tanto quedaran 2 copias del libro en posicion 2 y 3.
        for(int i = 0; i<librero.length; i++){
            if(librero[i] != null){
                librero[i] = null;
            }
        }
        // Luego entonces copiamos todos los elementos del arreglo ya ordenado a nuestro arreglo original.
        for(int i = 0; i < contador; i++) {
            librero[i] = elementosNoNulos[i];
	    
        }	
    }
  
    
    //Metodo para borrar la biblioteca
    public void borrarBiblioteca(){
        //Si durante la iteracion que recorre al arreglo se encuentra con un elemento no nulo, lo vuelve nulo.
        for(int i = 0; i<librero.length; i++){
            if(librero[i] != null){
                librero[i] = null;
            }
        }
    }


    public static void main(String [] args){
        // Por la naturaleza de los metodos cree una clase de Estanteria sobre la cual modificar mi arreglo original.
        Actividad1 mia = new Actividad1();
        Scanner tecladito = new Scanner(System.in);
        int opc_usuario = 0, confirmacion;
        //Esta es la interfaz con la que el usuario interactua hasta que este elija la opcion 8. Salir.
        System.out.println("-----------------Librero-----------------");
        do{
            System.out.println("Escribe tu opcion deseada:");
            System.out.println("1. Guardar Libro");
            System.out.println("2. Buscar Libro");
            System.out.println("3. Borrar Libro");
            System.out.println("4. Modificar Libro");
            System.out.println("5. Imprimir Biblioteca");
            System.out.println("6. Ordenar Biblioteca por Titulo");
            System.out.println("7. Borrar Biblioteca");
            System.out.println("8. Salir");
            opc_usuario = tecladito.nextInt();
            switch(opc_usuario){
            case 1:
                mia.agregarLibro();
                break;
            case 2:
                mia.buscarLibro();
                break;
            case 3:
                mia.eliminarLibro();
                break;
            case 4:
                mia.modificarLibro();
                break;
            case 5:
                mia.imprimirLibrero();
                break;
            case 6:
                mia.ordenarLibrero();
                break;
            case 7:
                System.out.println("Desea borrar todos los elementos?");
                System.out.println("1. Si");
                System.out.println("2. No");
                confirmacion = tecladito.nextInt();
                if(confirmacion == 1){
                    System.out.println("De acuerdo.");
                    mia.borrarBiblioteca();
                }
                else{
                    System.out.println("Regresando al menú...");
                }
                break;
            case 8:
                System.out.println("Gracias por usar el librero");
                break;
            }
        }while(opc_usuario != 8);
    }
}
