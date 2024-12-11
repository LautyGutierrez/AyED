package tp04.ejercicio1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		if (this.esVacio()) return -1;
		else {
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
			ArbolGeneral<T> arbol = new ArbolGeneral<>(null);
			cola.encolar(this);
			cola.encolar(null);
			int altura = 0;
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if(arbol != null) {
					if(arbol.tieneHijos()) {
						arbol.getHijos().comenzar();
						while(!arbol.getHijos().fin()) {
							cola.encolar(arbol.getHijos().proximo());
						}
					}
				} else if (!cola.esVacia()) {
					cola.encolar(null);
					altura +=1;
				}
			}
			return altura;
		}
	}

	public Integer nivel(T dato) {
		if (this.esVacio()) return -1;
		else {
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
			ArbolGeneral<T> arbol = new ArbolGeneral<>(null);
			cola.encolar(this);
			cola.encolar(null);
			int nivel = 0;
			boolean ok = false;
			while (!cola.esVacia() && (!ok)) {
				arbol = cola.desencolar();
				if(arbol != null) {
					if(arbol.getDato() == dato) {
						ok = true;
					} else {
						if(arbol.tieneHijos()) {
							arbol.getHijos().comenzar();
							while(!arbol.getHijos().fin()) {
								cola.encolar(arbol.getHijos().proximo());
							}
						}
					}
				} else if (!cola.esVacia()) {
					cola.encolar(null);
					nivel +=1;
				}
			}
			if (ok == false) nivel = -1;
			return nivel;
		}
	}

	public Integer ancho() {
		if(this.esVacio()) return -1;
		else {
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
			ArbolGeneral<T> arbol = new ArbolGeneral<>(null);
			cola.encolar(this);
			cola.encolar(null);
			int max = 0;
			int cant = 0;
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if (arbol != null) {
					cant += 1;
					if (arbol.tieneHijos()) {
						arbol.getHijos().comenzar();
						while(!arbol.getHijos().fin()) {
							cola.encolar(arbol.getHijos().proximo());
						}
					}
				} else if (!cola.esVacia()) {
					cola.encolar(null);
					max = Math.max(max, cant);
					cant = 0;
				}
			}
			max = Math.max(max, cant);
			return max;
		}
	}
	
	public Boolean esAncestro(T a, T b) {
		boolean ok = false;
		if (!this.esVacio()) {
			ArbolGeneral<T> subArbol = buscarValor(a, this);
			if (subArbol != null) {
				subArbol = buscarValor(b, subArbol);
				if(subArbol != null) {
					ok = true;
				}
			}
		}
		return ok;
	}
	
	private ArbolGeneral<T> buscarValor (T a, ArbolGeneral<T> arbol){
		ArbolGeneral<T> ag = null;
		if (arbol.getDato().equals(a)) {
			ag = arbol;
		} else if (arbol.tieneHijos()) {
			arbol.getHijos().comenzar();
			boolean encontre = false;
			while(!arbol.getHijos().fin() && !encontre) {
				ag = buscarValor(a, arbol.getHijos().proximo());
				if(ag != null) {
					encontre = true;
				}
			}
		}
		return ag;
	}

}