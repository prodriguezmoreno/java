package infinity;

public class Ps5 extends Juegos{
	private double precio;
	private String psPlus;
	
	
	public Ps5(int cod, String nombre, Stock stock, double precio, String psPlus) {
		super(cod, nombre, stock);
		this.precio = precio;
		this.psPlus = psPlus;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getPsPlus() {
		return psPlus;
	}


	public void setPsPlus(String psPlus) {
		this.psPlus = psPlus;
	}


	@Override
	public String toString() {
		return "Ps5 precio:" + precio + ", psPlus:" + psPlus + ", cod:" + cod + ", nombre:" + nombre + ", stock:"
				+ stock;
	}
	
	
	
	
}
