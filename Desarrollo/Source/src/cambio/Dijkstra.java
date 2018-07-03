package cambio;

import java.util.PriorityQueue;

import cambio.Calle;
import cambio.Esquina;

public class Dijkstra {
	
	public static int[] camino;

public static int[] obtener(Grafo grafo, Esquina nodoInicial) throws Exception{
		
		int[] distancia  = new int[grafo.getCantidadDeNodos()];
		boolean[] visitado  = new boolean[grafo.getCantidadDeNodos()];
		camino = new int[grafo.getCantidadDeNodos()];
		
		
		
		for(int i=0; i<grafo.getCantidadDeNodos(); i++){
			distancia[i] = Integer.MAX_VALUE;
			visitado[i] = false;
			camino[i] = -1;
		}
		
		distancia[nodoInicial.getIndex()] = 0;
		nodoInicial.setDistancia(0);
		
		PriorityQueue<Esquina> cola = new PriorityQueue<>();
		cola.add(nodoInicial);
		
		while(!cola.isEmpty()){
			Esquina nodoActual = cola.poll();
			visitado[nodoActual.getIndex()] = true;
			for(int ady = 0; ady < grafo.getCantidadDeNodos(); ady++){
				if(nodoActual.getIndex() != ady) {
					Calle a = grafo.getArista(nodoActual, new Esquina(ady));
					if(a != null){
						int dist = a.getCosto()+nodoActual.getDistancia();
						if(!visitado[ady] && dist <distancia[ady]) {
							distancia[ady] = dist;
							Esquina nodoInsertar = new Esquina(ady);
							nodoInsertar.setDistancia(dist);
							if(cola.contains(nodoInsertar)) {
								cola.remove(nodoInsertar);
							}
							camino[ady] = nodoActual.getIndex();
							cola.add(nodoInsertar);
						}
					}
				}
			}
		}
		
 		return distancia;
	}
}
