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
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		System.out.print("\n¿Cuantas recetas vas a escribir? ");
		cantrece = sc.nextInt();
	while (cantrece != 0) {

		Receta receta = new Receta ();
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
		ingredientes = new ArrayList<Ingrediente>();

		while (cantingre != 0 ){

			Ingrediente ingrediente = new Ingrediente ();
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
		ingredientes.add(ingrediente);
		cantingre = cantingre - 1;}
		receta.setingredientes(ingredientes);
		alReceta.add(receta);//del while
    	cantrece = cantrece - 1;
    	}		
		
		try{

			File fichero = new File ("/home/zubiri/proyectojava/java2/azterketa/recetas.txt");
			FileWriter fw = new FileWriter(fichero,true);

			for(int a=0; a<alReceta.size(); a++){
				ingredientes = alReceta.get(a).getingredientes();
				fw.write(alReceta.get(a).getnombreReceta()+";");
				for(int o=0; o<ingredientes.size(); o++){
					fw.write(ingredientes.get(o).getnombreIngrediente()+"*"+ingredientes.get(o).getcantidadGramos()+"*"+ingredientes.get(o).getcantidadUnidad()+"*"+ingredientes.get(o).getenGramos()+"#");
				}
				fw.write(";"+alReceta.get(a).getpReparacion()+"\n");
			}
			fw.close();

        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    	
		try{
			File archivorece = new File("/home/zubiri/proyectojava/java2/azterketa/recetas.txt");
			FileInputStream irastream = new FileInputStream(archivorece);
	        InputStreamReader ira = new InputStreamReader(irastream, "UTF8");
	        BufferedReader br = new BufferedReader(ira);

	        String linea;
	        linea = br.readLine();
	        String [] zatika = null;
	        System.out.println("\nRecetas:  ");
	        while(linea!=null){
	        	zatika = linea.split(";");
	        	System.out.println("--------------------------------");
	        	System.out.println("Nombre: "+zatika[0]);
	       		System.out.println("Preparacion: "+zatika[2]);
	       		String ingrez = zatika[1];
	       		zatika = ingrez.split("#");
	       		for(int x=0; x<zatika.length; x++){
	       			String ingrezatika = zatika[x];
	       			String [] zatika2 = ingrezatika.split("\\*");
	       			System.out.println("->Ingredientes: ");
	       			System.out.println("--->Nombre: "+zatika2[0]);
	       			System.out.println("--->Gramos: "+zatika2[1]);
	       			System.out.println("--->Unidades: "+zatika2[2]);
	       		}
	       		
	       		linea = br.readLine();
	        }
	        
	    }catch(Exception ioe){
	    	System.out.println("Error: "+ioe);
	    }
    	/*try{
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
	}*/
}
}