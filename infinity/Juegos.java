package infinity;

public abstract class Juegos {
	protected int cod;
	protected String nombre;
	protected Stock stock;
	
	
		public Juegos(int cod, String nombre, Stock stock) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.stock = stock;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	
	
}
