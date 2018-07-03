package cambio;
;

public class Grafo {

	private MatrizSimetrica aristas;
	private Esquina[] nodos;
	
	public Grafo(int cantidadDeNodos,int infinito){
		aristas= new MatrizSimetrica(cantidadDeNodos,infinito);
		nodos = new Esquina[cantidadDeNodos];
	}
	
	public void addNodo(Esquina n){
		nodos[n.getIndex()] = n;
	}
	
	public void addArista(Calle a){
		aristas.setValue(a.getNodoIzq().getIndex(), a.getNodoDer().getIndex(), a.getCosto());
	}

	public int getCantidadDeNodos() {
		// TODO Auto-generated method stub
		return aristas.getOrdenMatriz();
	}

	public Calle getArista(Esquina nodoInicial, Esquina nodoFinal) {
		
		int distancia = aristas.getValue(nodoInicial.getIndex(), nodoFinal.getIndex());
		if(distancia == aristas.getValorInifinito())
			return null;
		else
			return new Calle(nodoInicial,nodoFinal,distancia);
	}

	public Esquina[] getNodos() {
		// TODO Auto-generated method stub
		return nodos;
	}
	
	
}
