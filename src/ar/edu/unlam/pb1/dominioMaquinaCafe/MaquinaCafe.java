package ar.edu.unlam.pb1.dominioMaquinaCafe;

public class MaquinaCafe {

	private static final double PRECIO_CAFE = 200d;
	private static final double PRECIO_CAFE_CON_LECHE = 300d;
	private static final double PRECIO_CAPUCCINO = 400d;
	private int cantidadInicialAzucar;
	private int cantidadMinimaAzucar;
	private int cantidadMaximaAzucar;
	private double saldo;
	private double dineroMaquina;
	private int cafesDisponibles;
	private int cafesConLecheDisponibles;
	private int capuccinosDisponibles;
	private static int identificate;

	public MaquinaCafe(int cantidadInicialAzucar, int cantidadMinAzucar, int cantidadMaxAzucar) {
		this.cantidadInicialAzucar = cantidadInicialAzucar;
		this.cantidadMinimaAzucar = cantidadMinAzucar;
		this.cantidadMaximaAzucar = cantidadMaxAzucar;
		this.saldo = 0;
		this.dineroMaquina = 0;
		this.cafesDisponibles = 100;
		this.cafesConLecheDisponibles = 100;
		this.capuccinosDisponibles = 100;
		this.identificate=numeroIdentificador();
	}

	public boolean aumentarAzucar() {
		if (this.cantidadInicialAzucar < this.cantidadMaximaAzucar) {
			this.cantidadInicialAzucar++;
			return true;
		} else {
			return false;
		}
	}

	public boolean dismuniurAzucar() {
		if (this.cantidadInicialAzucar > this.cantidadMinimaAzucar) {
			this.cantidadInicialAzucar--;
			return true;
		} else {
			return false;
		}
	}

	public void ingresarDinero(double cantidadIngresada) {
		this.saldo += cantidadIngresada;

	}

	public boolean cobrarCafe() {
		if (this.saldo >= PRECIO_CAFE) {
			this.saldo -= PRECIO_CAFE;
			this.dineroMaquina += PRECIO_CAFE;
			return true;
		}
		return false;
	}

	public void expender(int opcionCafe) {
		switch (opcionCafe) {
		case 1:
			this.cafesDisponibles--;
			break;
		case 2:
			this.cafesConLecheDisponibles--;
			break;
		case 3:
			this.capuccinosDisponibles--;
			break;
		}

	}

	public boolean cobrarCafeConLeche() {
		if (this.saldo >= PRECIO_CAFE_CON_LECHE) {
			this.saldo -= PRECIO_CAFE_CON_LECHE;
			this.dineroMaquina += PRECIO_CAFE_CON_LECHE;
			return true;
		}
		return false;
	}

	public boolean cobrarCapuccino() {
		if (this.saldo >= PRECIO_CAPUCCINO) {
			this.saldo -= PRECIO_CAPUCCINO;
			this.dineroMaquina += PRECIO_CAPUCCINO;
			return true;
		}
		return false;
	}

	public double decirDineroMaquina() {
		return this.dineroMaquina;
	}

	public int verCantidadCafes() {
		return this.cafesDisponibles;
	}

	public int verCantidadCafeConLeche() {
		return this.cafesConLecheDisponibles;
	}

	public int verCantidadCapuccinos() {
		return this.capuccinosDisponibles;
	}
	public static int numeroIdentificador() {
		return identificate=(int)Math.round(Math.random()*(100-0+1)+0);
	}
}
