package cambio;


/*
 * Empleada para representar las adyacencias de un grafo no dirigido.
 */
public class MatrizSimetrica
{
	/*
	 * SI EL GRAFO ES NO PONDERADO CON BOOLEAN SERIA MAS QUE SUFICIENTE
	 */
	private int vec[];
	/*
	 * VALOR QUE REPRESENTARA EL INFINITO QUE SU USA PARA MARCAR QUE DOS NODOS NO ESTAN RELACIONADOS.
	 * SI FUERA NO PONDERADO NO EXISTIRIA YA QUE LA AUSENCIA DE RELACION SE REPRESENTA COMO FALSE.
	 */
	private int valorInfinito;
	
	/**
	 * 
	 * @param cantidadDeNodos 
	 * @param valorInfinito VALOR QUE SE UTILIZARA PARA REPRESENTAR EL INFINITO EJEMPLO Integer.MAX
	 */
	public MatrizSimetrica(int cantidadDeNodos, int valorInfinito){
		this.vec = new int[getSizeArray(cantidadDeNodos)];
		this.valorInfinito = valorInfinito;
		this.incializarMatriz(valorInfinito);
	}

	
	public int getValorInifinito(){
		return valorInfinito;
	}
	
	
	public int getValue(int fila, int columna){
		return fila == columna ? valorInfinito :  vec [ convertirFilaColumnaEnIndice(fila,columna) ];
	}
	
	public void setValue(int fila, int columna, int value){
		if(fila != columna)
			vec [ convertirFilaColumnaEnIndice(fila,columna) ] = value;
	}
	
	/**
	 * Convierte filas y columna de una matriz en un indice de vector
	 * @param fila
	 * @param columna
	 * @return
	 */
	private int convertirFilaColumnaEnIndice(int fila, int columna){;
		if(fila > columna){
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		int cantidadDeNodos = getOrdenMatriz();
		return fila * cantidadDeNodos + columna - (fila * fila + 3 * fila + 2)/2;
	}
	
	
	/***
	 * EL ORDEN DE LA MATRIZ REPRESENTA LA CANTIDAD DE NODOS DEL GRAFO.
	 * @return
	 */
	public int getOrdenMatriz()
	{
		return (int)(1+Math.sqrt((1+8*vec.length))/2);
	}
	
	
	/*
	 * CALCULAMOS EL TAMANIO DEL ARREGLO QUE REPRECENTARA A LA MATRIZ SIMETRICA
	 */
	private static int getSizeArray(int cantidadDeNodos){
		return cantidadDeNodos * ( cantidadDeNodos - 1 ) / 2;
	}

	public void incializarMatriz(int value){
		for(int i=0; i<vec.length; i++)
			vec[i] = valorInfinito;
	}

}