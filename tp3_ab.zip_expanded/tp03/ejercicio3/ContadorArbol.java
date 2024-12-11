package tp03.ejercicio3;
import tp02.ejercicio2.*;
import tp03.ejercicio1.*;
public class ContadorArbol {
	static ArbolBinario<Integer> a;
	
	public static ListaGenerica<Integer> numerosParesIn() {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		if (!a.esVacio()) {
			l = cargarListaIn(l, a);
		}
		return l;
	}
	private static ListaGenerica<Integer> cargarListaIn(ListaGenerica<Integer> l, ArbolBinario<Integer> a){
		if(a.tieneHijoIzquierdo()) {
			l = cargarListaIn(l, a.getHijoIzquierdo());
		}
		if ((a.getDato() % 2) == 0) {
			l.agregarFinal(a.getDato());
		}
		if (a.tieneHijoDerecho()) {
			l = cargarListaIn(l, a.getHijoDerecho());
		}
		return l;
	}
	
	public static ListaGenerica<Integer> numerosParesPost() {
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		if (!a.esVacio()) {
			l = cargarListaPost(l, a);
		}
		return l;
	}
	private static ListaGenerica<Integer> cargarListaPost(ListaGenerica<Integer> l, ArbolBinario<Integer> a){
		if(a.tieneHijoIzquierdo()) {
			l = cargarListaPost(l, a.getHijoIzquierdo());
		}
		if (a.tieneHijoDerecho()) {
			l = cargarListaPost(l, a.getHijoDerecho());
		}
		if ((a.getDato() % 2) == 0) {
			l.agregarFinal(a.getDato());
		}
		return l;
	}
	
	
	public static void main(String[] args) {
		a = new ArbolBinario<>(5);
		
		ArbolBinario<Integer> n1 = new ArbolBinario<>(7);
		ArbolBinario<Integer> n2 = new ArbolBinario<>(3);
		ArbolBinario<Integer> n3 = new ArbolBinario<>(4);
		ArbolBinario<Integer> n4 = new ArbolBinario<>(12);
		ArbolBinario<Integer> n5 = new ArbolBinario<>(7);
		ArbolBinario<Integer> n6 = new ArbolBinario<>(9);
		ArbolBinario<Integer> n7 = new ArbolBinario<>(6);
		ArbolBinario<Integer> n8 = new ArbolBinario<>(8);
		ArbolBinario<Integer> n9 = new ArbolBinario<>(10);
		ArbolBinario<Integer> n10 = new ArbolBinario<>(8);
		ArbolBinario<Integer> n11 = new ArbolBinario<>(15);
		ArbolBinario<Integer> n12 = new ArbolBinario<>(4);
		ArbolBinario<Integer> n13 = new ArbolBinario<>(5);
		ArbolBinario<Integer> n14 = new ArbolBinario<>(7);

		n3.agregarHijoIzquierdo(n7);
		n3.agregarHijoDerecho(n8);
		n4.agregarHijoIzquierdo(n9);
		n4.agregarHijoDerecho(n10);
		n5.agregarHijoIzquierdo(n11);
		n5.agregarHijoDerecho(n12);
		n6.agregarHijoIzquierdo(n13);
		n6.agregarHijoDerecho(n14);
		n1.agregarHijoIzquierdo(n3);
		n1.agregarHijoDerecho(n4);
		n2.agregarHijoIzquierdo(n5);
		n2.agregarHijoDerecho(n6);
		a.agregarHijoIzquierdo(n1);
		a.agregarHijoDerecho(n2);
		ListaGenerica<Integer> lista;
		lista = numerosParesIn();
		lista.comenzar();
		ListaGenerica<Integer> lista2;
		lista2 = numerosParesPost();
		lista2.comenzar();
		while(!lista.fin()) {
				System.out.println(lista.proximo());
		} 
		System.out.println("-------------");
		while(!lista2.fin()) {
			System.out.println(lista2.proximo());
		} 

}
	
}
