/**
 * 
 */
package cambio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Laboratorios
 *
 */
public class Cambio {
	
	private File archivo;
	private int esquinaInicial, esquinaFinal;
	private Grafo grafo;
	private Calle[] aristas;
	/**
	 * 
	 */
	public Cambio(File archivo) {
		// TODO Auto-generated constructor stub
		this.archivo = archivo;
		Scanner pl = null;
		try {
			pl = new Scanner(this.archivo);
			int cantNodos = pl.nextInt();
			esquinaInicial = pl.nextInt();
			esquinaFinal = pl.nextInt();
			pl.nextLine();
			int cantCalles = pl.nextInt();
			pl.nextLine();
			grafo = new Grafo(cantNodos,Integer.MAX_VALUE);
			aristas = new Calle[cantCalles];
			for (int i = 0; i < cantCalles; i++) {
				int numNodo = pl.nextInt();
				Esquina a = new Esquina(numNodo - 1);
				grafo.addNodo(a);
				numNodo = pl.nextInt();
				Esquina b = new Esquina(numNodo - 1);
				grafo.addNodo(b);
				grafo.addArista(aristas[i] = new Calle(a, b, pl.nextInt()));
				pl.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("ERROR: No se puede leer el archivo: (" + e.getMessage() + ")");
		} finally {
			if(pl != null) {
				pl.close();
			}
		}
	}
	
	public void obtenerResultado() {
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		int pos = esquinaFinal-1,cont=1;
		int[] vRecorrido = new int[grafo.getCantidadDeNodos()];
		ArrayList<Integer> calles = new ArrayList<>();
		try {
			fw = new FileWriter(archivo.getAbsolutePath().substring(0, archivo.getAbsolutePath().lastIndexOf(".")) + ".out");
			pw = new PrintWriter(fw);
			int[] distancias = Dijkstra.obtener(grafo, new Esquina(esquinaInicial - 1));
			pw.println(distancias[esquinaFinal-1]);
			vRecorrido[0] = pos;
			while(esquinaInicial-1!=Dijkstra.camino[pos]){
				vRecorrido[cont++] = Dijkstra.camino[pos];
				pos = Dijkstra.camino[pos];
			}
			vRecorrido[cont] = Dijkstra.camino[pos];
			for (int i = cont; i>0; i--) {
				for (int j = 0; j < aristas.length; j++) {
					if(vRecorrido[i]==aristas[j].getNodoDer().getIndex() && vRecorrido[i-1]==aristas[j].getNodoIzq().getIndex())
						calles.add(j + 1);
				}
			}
			Collections.sort(calles);
			for (int i = 0; i < calles.size(); i++) {
				pw.print(calles.get(i) + " ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("ERROR: " + e.getMessage());
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
	
	

}
