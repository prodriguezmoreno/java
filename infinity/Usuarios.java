package infinity;

public class Usuarios {
	private String nombre;
	private String pass;
	private String repass;

	public Usuarios(String nombre, String pass, String repass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.repass = repass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	@Override
	public String toString() {
		return "Nombre de usuario: " + nombre;
	}

}
