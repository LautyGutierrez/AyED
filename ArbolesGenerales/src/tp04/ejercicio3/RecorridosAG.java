package tp04.ejercicio3;
import tp02.ejercicio2.*;
import tp04.ejercicio1.*;
import tp02.ejercicio3.*;
public class RecorridosAG {
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		if (!a.esVacio()) {
			lista = imparesPreOrden(a, n, lista);
		}
		return lista;
	}
	
	private ListaGenerica<Integer> imparesPreOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if (((a.getDato()%2)==1) && a.getDato()>n) {
			l.agregarFinal(a.getDato());
		}
		if (a.tieneHijos()) {
			a.getHijos().comenzar();
			while (!a.getHijos().fin()) {
				l=imparesPreOrden(a.getHijos().proximo(),n,l);
			}
		}
		return l;
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		if (!a.esVacio()) {
			lista = imparesInOrden(a, n, lista);
		}
		return lista;
	}
	
	private ListaGenerica<Integer> imparesInOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if (a.tieneHijos()) {
			a.getHijos().comenzar();
			l = imparesInOrden(a.getHijos().proximo(), n, l);
		}
		if (((a.getDato()%2)==1) && a.getDato()>n) {
			l.agregarFinal(a.getDato());
		}
		if (a.tieneHijos()) {
			while (!a.getHijos().fin()) {
				l=imparesPreOrden(a.getHijos().proximo(),n,l);
			}
		}
		return l;
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		if (!a.esVacio()) {
			lista = imparesPostOrden(a, n, lista);
		}
		return lista;
	}
	
	private ListaGenerica<Integer> imparesPostOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if (a.tieneHijos()) {
			a.getHijos().comenzar();
			while (!a.getHijos().fin()) {
				l=imparesPostOrden(a.getHijos().proximo(),n,l);
			}
		}
		if (((a.getDato()%2)==1) && a.getDato()>n) {
			l.agregarFinal(a.getDato());
		}
		return l;
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		if (!a.esVacio()) {
			ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
			cola.encolar(a);
			cola.encolar(null);
			ArbolGeneral<Integer> arbol = new ArbolGeneral<>(null);
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if (arbol != null) {
					if (((arbol.getDato()%2)==1) && arbol.getDato()>n) {
						lista.agregarFinal(a.getDato());
					}
					if (arbol.tieneHijos()) {
						arbol.getHijos().comenzar();
						while (!arbol.getHijos().fin()) {
							cola.encolar(arbol.getHijos().proximo());
						}
					}
				} else if (!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return lista;
	}
	
	public static void main(String[] args) {
		System.out.println("hola");
	}
	
}
