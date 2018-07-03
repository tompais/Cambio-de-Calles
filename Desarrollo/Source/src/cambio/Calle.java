package cambio;

public class Calle {
	private Esquina nodoIzq;
	private Esquina nodoDer;
	private int costo;
	
	public Calle(Esquina nodoIzq, Esquina nodoDer, int costo) {
		super();
		this.nodoIzq = nodoIzq;
		this.nodoDer = nodoDer;
		this.costo = costo;
	}
	
	public Esquina getNodoIzq() {
		return nodoIzq;
	}
	public void setNodoIzq(Esquina nodoIzq) {
		this.nodoIzq = nodoIzq;
	}
	public Esquina getNodoDer() {
		return nodoDer;
	}
	public void setNodoDer(Esquina nodoDer) {
		this.nodoDer = nodoDer;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
}
