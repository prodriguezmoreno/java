package infinity;

public class Steam extends Juegos {
	private double precio;
	private String jugadores;

	
	public Steam(int cod, String nombre, Stock stock, double precio, String jugadores) {
		super(cod, nombre, stock);
		this.precio = precio;
		this.jugadores = jugadores;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getJugadores() {
		return jugadores;
	}



	public void setJugadores(String jugadores) {
		this.jugadores = jugadores;
	}



	@Override
	public String toString() {
		return "Steam precio:" + precio + ", jugadores=:" + jugadores + ", cod:" + cod + ", nombre:" + nombre
				+ ", stock:" + stock;
	}
	
	
	
	
	
}
