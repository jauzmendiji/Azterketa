import java.util.*;
import java.io.*;

public class cenaAmigos {

	public static void main (String args[]) {

		String nombrereceta, preparacion, nombreingrediente, resp;
		int cantidadgramos, cantidadunidad, cantrece, cantingre;
		boolean engramos;

		
	//Pedir cantidad recetas

		Scanner sc = new Scanner(System.in);
		ArrayList<Receta> alReceta = new ArrayList<Receta>();
		ArrayList<Ingrediente> alIngrediente = new ArrayList<Ingrediente>();
		Receta receta = new Receta ();
		Ingrediente ingrediente = new Ingrediente ();	
		System.out.print("\n¿Cuantas recetas vas a escribir? ");
		cantrece = sc.nextInt();
	while (cantrece != 0) {

		System.out.print("\nInformacion de la receta -->  ");
		System.out.print("\n\nNombre de la receta: ");
		nombrereceta = sc.next();
		receta.setnombreReceta(nombrereceta);
		System.out.print("\nPreparacion de la receta: ");
		preparacion = sc.next();
		receta.setpReparacion(preparacion);
		System.out.print("\n\n--Ingredientes------- ");
		System.out.print("\n¿Cuantos ingredientes utilizaras?");
		cantingre = sc.nextInt();
		while (cantingre != 0 ){

			System.out.print("\nNombre del ingrediente: ");
			nombreingrediente = sc.next();
			ingrediente.setnombreIngrediente(nombreingrediente);
			System.out.print("\nMediras los ingredientes en gramos o unidades? (Escribe gramos o unidades)");
			resp = sc.next();
				if ( resp.equals("gramos")){
					System.out.print("\nCantidad en gramos: ");
					engramos = true;
					cantidadunidad = -1;
					cantidadgramos = sc.nextInt();
					ingrediente.setenGramos(engramos);
					ingrediente.setcantidadUnidad(cantidadunidad);
					ingrediente.setcantidadGramos(cantidadgramos);
					
				}
				else if ( resp.equals("unidades")) {
					System.out.print("\nNumero de unidades: ");
					engramos = false;
					cantidadgramos = -1;
					cantidadunidad = sc.nextInt();
					ingrediente.setenGramos(engramos);
					ingrediente.setcantidadUnidad(cantidadunidad);
					ingrediente.setcantidadGramos(cantidadgramos);
					
				}
				else {
					System.out.print("\nRespuesta invalida");
				}
		alIngrediente.add(ingrediente);}		
		receta.setIngredientes(alIngrediente);
		alReceta.add(receta);		
		cantingre = cantingre - 1;	
		

		Iterator<Ingrediente> itrIngre = alIngrediente.iterator();
			Ingrediente part = (Ingrediente)itrIngre.next();

		try{
            
            File fichero = new File ("/home/zubiri/proyectojava/java2/azterketa/recetas.txt");
            FileWriter fw = new FileWriter("/home/zubiri/proyectojava/java2/azterketa/recetas.txt", true);
            //Escribimos en el fichero
            fw.write(nombrereceta + ";" + part.getnombreIngrediente() +  "*" + part.getcantidadGramos() + "*" + part.getcantidadUnidad() + "*" + part.getenGramos()+ ";" + preparacion + "\n");
            //Cierro
            fw.close(); 
            //Abro el stream, el fichero debe existir
            FileReader fr = new FileReader("/home/zubiri/proyectojava/java2/azterketa/recetas.txt");
            //Cerramos el stream
            fr.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    	//del while
    	cantrece = cantrece - 1;
    	}

    	try{
    FileReader fr = new FileReader ("/home/zubiri/proyectojava/java2/azterketa/recetas.txt");
	BufferedReader br = new BufferedReader(fr); 
	String s; 
		while((s = br.readLine()) != null) { 
	System.out.println(s); 
		} 
	fr.close(); 
		} 
	catch (IOException ioe) {
			System.out.println("Error E/S: " + ioe);
	}
}
}