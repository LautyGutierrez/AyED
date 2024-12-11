package tp06.ejercicio6;
import tp06.ejercicio3.*;
import tp02.ejercicio2.*;
public class VisitaOslo {
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> restringidos){
		ListaGenerica<String> l = new ListaEnlazadaGenerica<String>();
		if(!lugares.esVacio()) {
			boolean[] marca = new boolean[lugares.listaDeVertices().tamanio()+1];
			ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
			vertices.comenzar();
			Vertice<String> v = vertices.proximo();
			int i = 1;
			while(!vertices.fin() && !v.dato().equals("Ayuntamiento")){
				v = vertices.proximo();
				i++;
			}
			if(v.dato().equals("Ayuntamiento")) {
				dfs(i, destino, lugares, maxTiempo, restringidos, l, marca);
			}
		}
		return l;
	}
	private boolean dfs(int i, String destino, Grafo<String> grafo, int maxTiempo, ListaGenerica<String> restringidos, ListaGenerica<String> l, boolean[] marca) {
		boolean ok = false;
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		l.agregarFinal(v.dato());
		if(v.dato().equals(destino)){
			ok = true;
		} else {
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !ok) {
				Arista<String> arista = ady.proximo();
				String lugar = arista.verticeDestino().dato();
				if(!restringidos.incluye(lugar)) {
					int peso = arista.peso();
					if(maxTiempo-peso >=0) {
						int j = arista.verticeDestino().getPosicion();
						if(!marca[j]) {
							ok = dfs(j, destino, grafo, maxTiempo-peso, restringidos, l, marca);
						}
					}
				}
			}
			if(!ok) {
				l.eliminarEn(l.tamanio());
				marca[i] = false;
			}
		}
		return ok;
	}
}
