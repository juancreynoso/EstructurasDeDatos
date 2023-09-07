package datos;

public class Racional {

	//Attributes
	private long numerador;
	private long denominador;

	//Empty constructor
	public Racional() {
		numerador = 0;
		denominador = 1;
	}

	//Parametrized constructor
	public Racional(long numerador, long denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	//Setters
	public void setNumerador(long numerador) {
		this.numerador = numerador;
	}

	public void setDenominador(long denominador) {
		this.denominador = denominador;
	}

	//Getters
	public long getNumerador() {
		return numerador;
	}

	public long getDenominador() {
		return denominador;
	}

	//Suma racionales
	public Racional suma(Racional num1) {
		Racional otro = new Racional();

		long a = num1.getNumerador();
		long b = num1.getDenominador();
		long c = numerador;
		long d = denominador;

		otro.setNumerador((a*d) + (b*c));
		otro.setDenominador(b*d);

		return otro;
	}

	public Racional resta(Racional num1) {
		Racional otro = new Racional();

		long a = num1.getNumerador();
		long b = num1.getDenominador();
		long c = numerador;
		long d = denominador;

		otro.setNumerador((a*d) - (b*c));
		otro.setDenominador(b*d);

		return otro;
	}

	@Override
	public boolean equals(Object otro) {
		if (otro == null)
			return false;
		if (otro == this)
			return true;
		if (!(otro instanceof Racional))
			return false;
		Racional otroRacional = (Racional) otro;
		return otroRacional.denominador * numerador == otroRacional.numerador * denominador;

	}

	/**
	 * Retorna del numero racional
	 * @return número racional
	 **/
	@Override
	public String toString() {
		return numerador + "/"+ denominador;
	}
}
