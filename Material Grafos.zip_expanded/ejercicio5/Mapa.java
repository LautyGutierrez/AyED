package ejercicio5;
import tp06.ejercicio3.*;
import tp02.ejercicio2.*;
public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa(Grafo<String> mapa) {
		mapaCiudades = mapa;
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		if(!this.mapaCiudades.esVacio()) {
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()+1];
			ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
			vertices.comenzar();
			Vertice<String> v = vertices.proximo();
			int i = 1;
			while((!vertices.fin()) && (!v.dato().equals(ciudad1))) {
				v = vertices.proximo();
				i++;
			}
			if (v.dato().equals(ciudad1)) {
				boolean ok = devolverCamino2(i, ciudad2, lista, marca);
			}
		}
		return lista;
	}
	private boolean devolverCamino2(int i, String ciudad2, ListaGenerica<String> lista, boolean[] marca) {
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		lista.agregarFinal(v.dato());
		boolean ok = false;
		if(v.dato().equals(ciudad2)) {
			ok = true;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while((!ady.fin()) && (!ok)) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					ok = devolverCamino2(j, ciudad2, lista, marca);
				}
			}
			if(!ok) {
				lista.eliminarEn(lista.tamanio());
			}
		}
		return ok;
	}
	
	//-------------------------------------------------------------------------------//
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> lista){
		ListaGenerica<String> l = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
			vertices.comenzar();
			Vertice<String> v = vertices.proximo();
			int i = 1;
			while((!vertices.fin()) && (!v.dato().equals(ciudad1))) {
				v = vertices.proximo();
				i++;
			}
			if(v.dato().equals(ciudad1)) {
				boolean ok = devolverCaminoExceptuando2(i, ciudad2, lista, l, marca);
			}
		}
		return l;
	}
	private boolean devolverCaminoExceptuando2(int i, String ciudad2, ListaGenerica<String> lista, ListaGenerica<String> l, boolean[] marca) {
		boolean ok = false;
		marca[i]=true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		l.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			ok = true;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while((!ady.fin() && (!ok))) {
				Arista<String> arista = ady.proximo();
				String ciudad = arista.verticeDestino().dato();
				if(!lista.incluye(ciudad)) {
					int j = arista.verticeDestino().getPosicion();
					if(!marca[j]) {
						ok = devolverCaminoExceptuando2(j, ciudad2, lista, l, marca);
					}
				}
			}
			if(!ok) {
				l.eliminarEn(l.tamanio());
			}
		}
		return ok;
	}
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		ListaGenerica<String> l = new ListaEnlazadaGenerica<String>();
		if(!this.mapaCiudades.esVacio()) {
			ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
			ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
			vertices.comenzar();
			int i = 1;
			Vertice<String> v = vertices.proximo();
			while(!vertices.fin() && !v.dato().equals(ciudad1)) {
				v = vertices.proximo();
				i++;
			}
			if (v.dato().equals(ciudad1)) {
				caminoMasCorto2(i, ciudad2, l, lista, marca);
			}
		}
		return l;
	}
	private void caminoMasCorto2(int i, String ciudad2, ListaGenerica<String> l, ListaGenerica<String> lista, boolean[] marca) {
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		lista.agregarFinal(v.dato());
		if(v.dato().equals(ciudad2)) {
			if(lista.tamanio()<l.tamanio() || l.tamanio()==0) {
				clonar(l, lista);
			}
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]){
					caminoMasCorto2(j, ciudad2, l, lista, marca);
				}
			}
		}
		marca[i] = false;
		lista.eliminarEn(lista.tamanio());
	}
	private void clonar(ListaGenerica<String> l, ListaGenerica<String> lista) {
		l.comenzar();
		while(l.tamanio() != 0) {
			l.eliminarEn(1);
		}
		lista.comenzar();
		String ciudad;
		while(!lista.fin()) {
			ciudad = lista.proximo();
			l.agregarFinal(ciudad);
		}
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> l = new ListaEnlazadaGenerica<String>();
		if(!this.mapaCiudades.esVacio()) {
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()+1];
			ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
			vertices.comenzar();
			Vertice<String> v = vertices.proximo();
			int i = 1;
			while(!vertices.fin() && !v.dato().equals(ciudad1)) {
				v = vertices.proximo();
				i++;
			}
			if(v.dato().equals(ciudad1)) {
				sinCargar(i, ciudad2, l, tanqueAuto, marca);
			}
		}
		return l;
	}
	private boolean sinCargar(int i, String ciudad2, ListaGenerica<String> l, int tanque, boolean[] marca) {
		boolean ok = false;
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		l.agregarFinal(v.dato());
		if(v.dato().equals(ciudad2)) {
			ok = true;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && !ok){
				Arista<String> arista = ady.proximo();
				int peso = arista.peso();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					if((tanque - peso) >= 0) {
						ok = sinCargar(j, ciudad2, l, tanque - peso, marca);	
					}
				}
				
			}
			if(!ok) {
				l.eliminarEn(l.tamanio());
			}
		}
		return ok;
	}
	//----------------------------------------------------------------------------------------//
	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		ListaGenerica<String> l = new ListaEnlazadaGenerica<String>();
		if (!this.mapaCiudades.esVacio()) {
			ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
			boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()+1];
			ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
			vertices.comenzar();
			Vertice<String> v = vertices.proximo();
			int i = 1;
			while(!vertices.fin() && !v.dato().equals(ciudad1)) {
				v = vertices.proximo();
				i++;
			}
			if(v.dato().equals(ciudad1)) {
				conCarga(i, ciudad2, l, lista, tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE, marca);
			}
		}
		return l;
	}
	private int conCarga(int i, String ciudad2, ListaGenerica<String> l, ListaGenerica<String> lista, int tanqueLleno, int tanqueAct, int cant, int cantMin, boolean[] marca) {
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		lista.agregarFinal(v.dato());
		if(v.dato().equals(ciudad2)) {
			if(cant<cantMin){
				clonar(l, lista);
				cantMin = cant;
			}
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				int peso = arista.peso();
				if(!marca[j]) {
					if(tanqueAct-peso >= 0) {
						cantMin = conCarga(j, ciudad2, l, lista, tanqueLleno, tanqueAct-peso, cant, cantMin, marca);
					} else if(peso<=tanqueLleno){	 
						cantMin = conCarga(j, ciudad2, l, lista, tanqueLleno, tanqueLleno, cant+1, cantMin, marca);
					}
				}
			}
		}
		lista.eliminarEn(lista.tamanio());
		marca[i] = false;
		return cantMin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
