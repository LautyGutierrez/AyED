package parciales;

import tp03.ejercicio1.*;
public class Parcial {
	static ArbolBinario<Integer> a;
	public static boolean esDeSeleccion (ArbolBinario<Integer> arbol){
		boolean ok = false;
		if (!arbol.esVacio()){
			ok = comprobarEsDeSeleccion(arbol);
		 }
		 return ok;
	}

	private static boolean comprobarEsDeSeleccion (ArbolBinario<Integer> arbol){
		boolean ok = true;
		int min = Integer.MAX_VALUE;
		if(arbol.tieneHijoIzquierdo()){
			ArbolBinario<Integer> hi = arbol.getHijoIzquierdo();
			min = Math.min(min, hi.getDato());
			ok = comprobarEsDeSeleccion(hi);
		}
		if ((ok) && (arbol.tieneHijoDerecho())) {
			ArbolBinario<Integer> hd = arbol.getHijoDerecho();
			min = Math.min(min, hd.getDato());
			ok = comprobarEsDeSeleccion(hd);
		}
		if (arbol.getDato() != min){
		    ok = false;
		}
		return ok;
	}
	
	//----------------------------------------------------------------------------------------------------------//
	
	public static boolean resolver(int k) {
		boolean ok = false;
		if (!a.esVacio()) {
			int suma = 0;
			ok = comprobarEsMonodistante(k, suma, a);
		}
		return ok;
	}
	
	private static boolean comprobarEsMonodistante(int k, int suma, ArbolBinario<Integer> arbol) {
		suma += arbol.getDato();
		boolean ok = true;
		if (suma <= k) {
			if (arbol.esHoja()) {
				if(suma == k) ok = true;
			} else {
				if (arbol.tieneHijoIzquierdo()) {
					ok = comprobarEsMonodistante(k, suma, arbol.getHijoIzquierdo());
				}
				if ((ok) && (arbol.tieneHijoDerecho())) {
					ok = comprobarEsMonodistante(k, suma, arbol.getHijoDerecho());
				}
			}
		} else {
			ok = false;
		}
		return ok;
	}
}
