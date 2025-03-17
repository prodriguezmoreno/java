package infinity;

import java.util.ArrayList;

public class Excepciones {

	public static void ValidarSocio(String nombre, ArrayList<Usuarios> usuarios) throws ExcepcionPersonal {
		boolean existe = false;
		for (Usuarios usu : usuarios) {
			if (nombre.equals(usu.getNombre())) {
				existe = true;
				break;

			}
		}
		if (!existe) {
			throw new ExcepcionPersonal("El nombre de usuario " + nombre + " no existe");
		}

	}

	public static void ValidarPass(String nombre, String pass, ArrayList<Usuarios> usuarios) throws ExcepcionPersonal {
		for (Usuarios usu : usuarios) {
			if (nombre.equals(usu.getNombre())) {
				if (!pass.equals(usu.getPass())) {
					throw new ExcepcionPersonal("La contraseña no es correcta para el usuario");
				} else {
					System.out.println("Se inicio sesión como: " + nombre);
					return;
				}
			}
		}

	}

	public static void AñadirJuego(int cod, ArrayList<Juegos> juegos, ArrayList<Juegos> cesta)
			throws ExcepcionPersonal {
		boolean existe = false;
		for (Juegos jue : juegos) {
			if (cod == jue.getCod()) {
				existe = true;
				if (existe == true) {
					if (jue.getStock().equals(Stock.DISPONIBLE)) {
						cesta.add(jue);
						System.out.println("Añadiste el  juego con codigo " + cod + " a tu cesta");
						break;
					} else {
						throw new ExcepcionPersonal("El juego existe pero esta agotado");
					}

				}

			}

		}
		if (!existe) {
			throw new ExcepcionPersonal("El codigo del juego que seleccionaste no existe");
		}
	}

	public static void AñadirUsuario(String nombreN, String passN, String rPassN, ArrayList<Usuarios> usuarios)
			throws ExcepcionPersonal {
		boolean existe = false;
		for (Usuarios usu : usuarios) {
			if (nombreN.equals(usu.getNombre())) {
				existe = true;
			} else {
				System.out.println("El nombre de usuario esta libre");
			}
		}
		if (existe) {
			throw new ExcepcionPersonal("El nombre de usuario ya esta en uso");

		}
	}

	public static void ValidarPass(String passN, String rPassN) throws ExcepcionPersonal {
		if (passN.equals(rPassN)) {
			System.out.println("Ambas contraseñas coinciden");
		} else {
			throw new ExcepcionPersonal("Las contraseñas no coinciden");
		}
	}

}
