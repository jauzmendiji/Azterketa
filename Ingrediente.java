public class Ingrediente {
	String nombreIngrediente;
	int cantidadGramos, cantidadUnidad;
	boolean enGramos;

	public void setnombreIngrediente (String ni){
		nombreIngrediente = ni;
	}
	public String getnombreIngrediente(){
		return nombreIngrediente;
	}

	public void setcantidadGramos (int cg){
		cantidadGramos = cg;
	}
	public int getcantidadGramos(){
		return cantidadGramos;
	}

	public void setcantidadUnidad (int cu){
		cantidadUnidad = cu;
	}
	public int getcantidadUnidad(){
		return cantidadUnidad;
	}

	public void setenGramos (boolean eng){
		enGramos = eng;
	}
	public boolean getenGramos(){
		return enGramos;
	}
}