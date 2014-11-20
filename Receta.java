import java.util.*;

public class Receta {
	private String nombreReceta, pReparacion;
	ArrayList<Ingrediente> ingredientes;

	public void setnombreReceta (String nr){
		nombreReceta = nr;
	}
	public String getnombreReceta(){
		return nombreReceta;
	}

	public void setpReparacion (String prep){
		pReparacion = prep;
	}
	public String getpReparacion(){
		return pReparacion;
	}

}
