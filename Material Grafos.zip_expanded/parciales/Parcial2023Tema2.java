package parciales;
import tp06.ejercicio3.*;
import tp02.ejercicio2.*;
public class Parcial2023Tema2 {
	public ListaGenerica<String> resolver(Grafo<String> sitios, String origen, int maxTiempo){
		ListaGenerica<String> l = new ListaEnlazadaGenerica<String>();
		if (!sitios.esVacio()) {
			boolean[] marca = new boolean[sitios.listaDeVertices().tamanio()+1];
			ListaGenerica<Vertice<String>> vertices = sitios.listaDeVertices();
			ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
			vertices.comenzar();
			int i = 1;
			Vertice<String> v = vertices.proximo();
			while(!vertices.fin() && !v.dato().equals("Estadio Unico")) {
				v = vertices.proximo();
				i++;
			}
			if(v.dato().equals("Estadio Unico")) {
				int tiempo = dfs(i, sitios, l, lista, 1, Integer.MAX_VALUE, 0, maxTiempo, marca);
			}
		}
		return l;
	}
	private int dfs(int i, Grafo<String> sitios, ListaGenerica<String> l, ListaGenerica<String> lista, int cantV, int tiempoMin,int tiempoAct, int maxTiempo, boolean[] marca) {
		marca[i] = true;
		Vertice<String> v = sitios.listaDeVertices().elemento(i);
		lista.agregarFinal(v.dato());
		ListaGenerica<Arista<String>> ady = sitios.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<String> arista = ady.proximo();
			if(maxTiempo-arista.verticeDestino().tiempo()<=)
		}
		
		return tiempoMin;
	}
}
