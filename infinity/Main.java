package infinity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Juegos> juegos = new ArrayList<Juegos>();
		ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
		ArrayList<Juegos> cesta = new ArrayList<Juegos>();

		Usuarios pablo = new Usuarios("Pablo", "1234", "1234");
		Usuarios admin = new Usuarios("admin", "admin", "admin");

		usuarios.add(admin);
		usuarios.add(pablo);

		// Juegos Steam
		juegos.add(new Steam(1, "The Witcher 3: Wild Hunt", Stock.DISPONIBLE, 49.99, "Un jugador"));
		juegos.add(new Steam(2, "Dota 2", Stock.DISPONIBLE, 0.00, "Multijugador"));
		juegos.add(new Steam(3, "Counter-Strike: Global Offensive", Stock.DISPONIBLE, 14.99, "Multijugador"));
		juegos.add(new Steam(4, "Cyberpunk 2077", Stock.AGOTADO, 59.99, "Un jugador"));
		juegos.add(new Steam(5, "Stardew Valley", Stock.DISPONIBLE, 14.99, "Un jugador"));
		juegos.add(new Steam(6, "Left 4 Dead 2", Stock.DISPONIBLE, 9.99, "Multijugador"));
		juegos.add(new Steam(7, "Hunt: Showdown", Stock.DISPONIBLE, 39.99, "Multijugador"));
		juegos.add(new Steam(8, "Team Fortress 2", Stock.DISPONIBLE, 0.00, "Multijugador"));
		juegos.add(new Steam(9, "Grand Theft Auto V", Stock.AGOTADO, 29.99, "Multijugador"));
		juegos.add(new Steam(10, "DOOM Eternal", Stock.DISPONIBLE, 39.99, "Un jugador"));

		// Juegos PS5
		juegos.add(new Ps5(11, "Spider-Man: Miles Morales", Stock.DISPONIBLE, 49.99, "PS Plus Obligatorio"));
		juegos.add(new Ps5(12, "Ratchet & Clank: Rift Apart", Stock.DISPONIBLE, 69.99, "Opcional"));
		juegos.add(new Ps5(13, "Horizon Forbidden West", Stock.DISPONIBLE, 69.99, "PS Plus Obligatorio"));
		juegos.add(new Ps5(14, "Demon's Souls", Stock.DISPONIBLE, 69.99, "Opcional"));
		juegos.add(new Ps5(15, "Returnal", Stock.AGOTADO, 69.99, "PS Plus Obligatorio"));
		juegos.add(new Ps5(16, "Gran Turismo 7", Stock.DISPONIBLE, 59.99, "Opcional"));
		juegos.add(new Ps5(17, "Final Fantasy VII Remake Intergrade", Stock.DISPONIBLE, 49.99, "Opcional"));
		juegos.add(new Ps5(18, "Ghost of Tsushima Director's Cut", Stock.DISPONIBLE, 79.99, "PS Plus Obligatorio"));
		juegos.add(new Ps5(19, "Resident Evil Village", Stock.DISPONIBLE, 59.99, "Opcional"));
		juegos.add(new Ps5(20, "The Last of Us Part II", Stock.AGOTADO, 49.99, "PS Plus Obligatorio"));

		Scanner input = new Scanner(System.in);
		int eleccion = 1;
		boolean ini = false;
		while (eleccion > 0) {
			System.out.println();
			System.out.println("----Menu de compras de juegos----");
			System.out.println("1--Iniciar sesion con tu usuario");
			System.out.println("2--Listar todos los juegos");
			System.out.println("3--Listar juegos Steam");
			System.out.println("4--Listar juegos Ps5");
			System.out.println("5--Añadir a tu cesta");
			System.out.println("6--Listar tu cesta");
			System.out.println("7--Cerrar sesion");
			System.out.println("8--Registrar nuevo usuario");
			System.out.println("0--Salir");
			try {
			eleccion = input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Error  debes introducir un numero " );
				eleccion=10;
			}
			int cod;
			String so;
			String cont;
			input.nextLine();
			switch (eleccion) {
			case 1:
				for (Usuarios usus : usuarios) {
					System.out.println(usus);
				}
				System.out.println("Introduzca el nombre de socio");
				so = input.nextLine();
				try {
					Excepciones.ValidarSocio(so, usuarios);

				} catch (ExcepcionPersonal e) {
					System.out.println("error " + e.getMessage());
					break;
				}
				System.out.println("Ahora vamos a comprobar tu contraseña");
				System.out.println("Introduce tu contraseña");
				cont = input.nextLine();
				try {
					Excepciones.ValidarPass(so, cont, usuarios);

				} catch (ExcepcionPersonal e) {
					System.out.println("Error " + e.getMessage());
				}
				ini = true;
				break;
			case 2:
				for (Juegos jueg : juegos) {
					System.out.println(jueg);
				}
				break;
			case 3:
				for (Juegos jueg : juegos) {
					if (jueg instanceof Steam) {
						System.out.println(jueg);
					}
				}
				break;
			case 4:
				for (Juegos jueg : juegos) {
					if (jueg instanceof Ps5) {
						System.out.println(jueg);
					}
				}
				break;
			case 5:
				if (ini == true) {
					System.out.println("Introduce el numero del juego que quieres añadir");
					cod = input.nextInt();
					try {
						Excepciones.AñadirJuego(cod, juegos, cesta);
					} catch (ExcepcionPersonal e) {
						System.out.println("Error :" + e.getMessage());
					}
				} else {
					System.out.println("No iniciaste sesión , por favor debes primero hacer login");
				}
				break;
			case 6:
				for (Juegos cest : cesta) {
					System.out.println(cest);

				}
				break;
			case 7:
				if (ini == false) {
					System.out.println("No has iniciado sesión, con lo que no la puedes cerrar");
				} else {
					ini = false;
					System.out.println("Cerraste la sesion satisfactoriamente");
				}
				break;
			case 8:
				System.out.println("Introduce el nombre que quieres para el usuario nuevo");
				String nombreN = input.nextLine();
				System.out.println("Introduce la constraseña para el usuario nuevo");
				String passN = input.nextLine();
				System.out.println("Introduce la constraseña de nuevo");
				String rPassn = input.nextLine();
				try {
					Excepciones.ValidarPass(passN, rPassn);
				} catch (ExcepcionPersonal e) {
					System.out.println("Error: " + e.getMessage());
					break;
				}
				Usuarios usuN = new Usuarios(nombreN, passN, rPassn);
				try {
					Excepciones.AñadirUsuario(nombreN, passN, rPassn, usuarios);
					usuarios.add(usuN);
				} catch (ExcepcionPersonal e) {
					System.out.println("error: " + e.getMessage());
				}
			}
		}
		input.close();
	}
}
