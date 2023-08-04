package es.cic;

public class BatidoraImpl {
	private int tiempoTotal;
	
	private Calculadora calculadora;
	
	


	public void calcularTiempos(int primero, int segundo) {
		this.tiempoTotal = calculadora.sumar(primero, segundo);
	}
	

	public Calculadora getCalculadora() {
		return calculadora;
	}


	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}


	public int getTiempoTotal() {
		return tiempoTotal;
	}


	public void setTiempoTotal(int tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

}
