package ejercicio5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Recorridos {
	public static void main(String[] args) {
		int i = 10;
		System.out.println(1+2+i);

	}
	
	public ListaGenerica<Vertice<Integer>> dfs(Grafo<Integer> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<Integer>> lista = new ListaEnlazadaGenerica<Vertice<Integer>>();
		for(int i = 1; i<= grafo.listaDeVertices().tamanio(); i++) {
			if(!marca[i]) {
				this.dfs(i, grafo, marca, lista);
			}
		}
		return lista;
	}
	private void dfs(int i, Grafo<Integer> grafo, boolean[] marca, ListaGenerica<Vertice<Integer>> lista) {
		marca[i] = true;
		Vertice<Integer> v = grafo.listaDeVertices().elemento(i);
		lista.agregarFinal(v);
		ListaGenerica<Arista<Integer>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		int j;
		while(!ady.fin()) {
			j = ady.proximo().verticeDestino().getPosicion();
			if(!marca[j]) {
				dfs(j, grafo, marca, lista);
			}
		}
	}
	
	public ListaGenerica<Vertice<Integer>> bfs(Grafo<Integer> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<Integer>> lista = new ListaEnlazadaGenerica<Vertice<Integer>>();
		for(int i = 1; i<= grafo.listaDeVertices().tamanio(); i++) {
			if(!marca[i]) {
				this.bfs(i, grafo, marca, lista);
			}
		}
		return lista;
	}
	private void bfs(int i, Grafo<Integer> grafo, boolean[] marca, ListaGenerica<Vertice<Integer>> lista) {
		marca[i] = true;
		ColaGenerica<Vertice<Integer>> cola = new ColaGenerica<Vertice<Integer>>();
		cola.encolar(grafo.listaDeVertices().elemento(i));
		cola.encolar(null);
		ListaGenerica<Arista<Integer>> ady = null;
		while(!cola.esVacia()) {
			Vertice<Integer> v = cola.desencolar();
			lista.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<Integer> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					Vertice<Integer> w = arista.verticeDestino();
					marca[j]=true;
					cola.encolar(w);
				}
			}
		}
	}
}
