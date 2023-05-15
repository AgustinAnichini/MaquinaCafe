package ar.edu.unlam.pb1.interfazMaquinaCafe;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominioMaquinaCafe.MaquinaCafe;

public class TestMaquinaCafe {
	public static Scanner teclado = new Scanner(System.in);
	private static final int CANTIDAD_MAX_AZUCAR = 5;
	private static final int CANTIDAD_MIN_AZUCAR = 0;
	private static final int CANTIDAD_INICIAL_AZUCAR = 3;
	private static final int OPCION_AUMENTAR_AZUCAR = 0;
	private static final int OPCION_DISMINUIR_AZUCAR = 1;
	private static final int OPCION_INGRESAR_DINERO = 2;
	private static final int OPCION_SELECIONAR_BEBIDA = 3;
	private static final char OPCION_SALIR = 9;
	private static final int OPCION_CAFE = 1;
	private static final int OPCION_CAFE_CON_LEHCE = 2;
	private static final int OPCION_CAPUCCINO = 3;
	private static final char OPCION_SALIR_CAFE = 4;

	public static void main(String[] args) {
		MaquinaCafe cafetera = new MaquinaCafe(CANTIDAD_INICIAL_AZUCAR, CANTIDAD_MIN_AZUCAR, CANTIDAD_MAX_AZUCAR);
		int opcion = 0;
		mostrarMensaje("El numero de identicicacion es: " + MaquinaCafe.numeroIdentificador());
		do {// para que se repita
			menuMaquinaCafe();
			opcion = teclado.nextInt();
			switch (opcion) {
			case OPCION_AUMENTAR_AZUCAR:
				aumentarAzucar(cafetera);
				break;
			case OPCION_DISMINUIR_AZUCAR:
				dismunuirAzucar(cafetera);
				break;
			case OPCION_INGRESAR_DINERO:
				ingresarDinero(cafetera);
				break;
			case OPCION_SELECIONAR_BEBIDA:
				menuCafes();
				selecionarBebida(cafetera);
				break;
			case OPCION_SALIR:
				mostrarMensaje("----MUCHAS GRACIAS POR VISITARNOS----");
				break;
			}
		} while (opcion != OPCION_SALIR);

	}

	private static void selecionarBebida(MaquinaCafe cafetera) {
		int opcionCafes = 0;
		boolean sePudoCobrar;
		do {
			opcionCafes = teclado.nextInt();
			switch (opcionCafes) {
			case OPCION_CAFE:
				sePudoCobrar = cafetera.cobrarCafe();
				if (sePudoCobrar) {
					mostrarMensaje("SE esta sirviendo un CAFE");
					cafetera.expender(OPCION_CAFE);
					mostrarMensaje("\nEn la maquina hay: " + cafetera.decirDineroMaquina());
					mostrarMensaje("Los Cafes disponibles son: " + cafetera.verCantidadCafes());
				} else {
					mostrarMensaje("MONTO INSUFICIENTE");
				}
				break;
			case OPCION_CAFE_CON_LEHCE:
				sePudoCobrar = cafetera.cobrarCafeConLeche();
				if (sePudoCobrar) {
					mostrarMensaje("SE esta sirviendo un CAFE CON LECHE");
					cafetera.expender(OPCION_CAFE_CON_LEHCE);
					mostrarMensaje("El dinero de la maquina es: " + cafetera.decirDineroMaquina());
					mostrarMensaje("Los Cafes con leche disponibles son: " + cafetera.verCantidadCafeConLeche());
				} else {
					mostrarMensaje("MONTO INSUFICIENTE");
				}
				break;
			case OPCION_CAPUCCINO:
				sePudoCobrar = cafetera.cobrarCapuccino();
				if (sePudoCobrar) {
					mostrarMensaje("SE esta sirviendo un CAPUCCINO");
					cafetera.expender(OPCION_CAPUCCINO);
					mostrarMensaje("En la maquina hay: " + cafetera.decirDineroMaquina());
					mostrarMensaje("Los Capiccinos disponibles son: " + cafetera.verCantidadCapuccinos());
				} else {
					mostrarMensaje("MONTO INSUFICIENTE");
				}
				break;
			case OPCION_SALIR_CAFE:
				mostrarMensaje("SALIENDO...");
//				menuMaquinaCafe();// NO SE SI VA
				break;
			}
		} while (opcionCafes != OPCION_SALIR_CAFE);

	}

	private static void ingresarDinero(MaquinaCafe cafetera) {
		double cantidadIngresada = ingresarCantidad("Ingresar Dinero");
		cafetera.ingresarDinero(cantidadIngresada);
	}

	private static void dismunuirAzucar(MaquinaCafe cafetera) {
		boolean disminuirAzucar = cafetera.dismuniurAzucar();
		if (disminuirAzucar) {
			mostrarMensaje("Se disminuto el azucar");
		} else {
			mostrarMensaje("NIVEL MINIMO DE AZUCAR");
		}
	}

	private static void aumentarAzucar(MaquinaCafe cafetera) {
		boolean aumentoAzucar = cafetera.aumentarAzucar();
		if (aumentoAzucar) {
			mostrarMensaje("Se le agrego mas azucar");
		} else {
			mostrarMensaje("NIVEL MAXIMO DE AZUCAR");
		}

	}

	private static void menuMaquinaCafe() {
		mostrarMensaje("----BIENVENIDO!! ELIGA UNA OPCION----");
		mostrarMensaje("\nIngrese 0 para aumentar el nivel de azucar");
		mostrarMensaje("Ingrese 1 para disminuir el nivel de azucar");
		mostrarMensaje("Ingrese 2 para ingresar Dinero");
		mostrarMensaje("Ingrese 3 para seleccionar bebida");
		mostrarMensaje("Ingrese 9 para salir");
	}

	public static void menuCafes() {
		mostrarMensaje("Ingrese 1 para un CAFE");
		mostrarMensaje("Ingrese 2 para un CAFE CON LECHE");
		mostrarMensaje("Ingrese 3 para un CAPUCCINO");
		mostrarMensaje("Ingrese 4 para SALIR");
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static double ingresarCantidad(String mensaje) {
		mostrarMensaje(mensaje);
		return teclado.nextDouble();
	}
}
