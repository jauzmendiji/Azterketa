import java.util.*;

public class Receta {
	private String nombreReceta, pReparacion;
	ArrayList<Ingrediente> ingredientes;

	public void setnombreReceta (String nr){
		this.nombreReceta = nr;
	}
	public String getnombreReceta(){
		return nombreReceta;
	}

	public void setingredientes (ArrayList<Ingrediente> ingrs){
		this.ingredientes = ingrs;
	}
	public ArrayList<Ingrediente> getingredientes(){
		return ingredientes;
	}

	public void setpReparacion (String prep){
		this.pReparacion = prep;
	}
	public String getpReparacion(){
		return pReparacion;
	}

}
