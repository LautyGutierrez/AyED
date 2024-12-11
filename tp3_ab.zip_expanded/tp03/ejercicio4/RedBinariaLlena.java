package tp03.ejercicio4;
import tp03.ejercicio1.*;
import java.util.Scanner;;
public class RedBinariaLlena {
	static ArbolBinario<Integer> a;
	
	public static int retardoReenvio() {
		int suma = 0;
		return recorrer(suma, a);
	}
	
	private static int recorrer(int suma, ArbolBinario<Integer> a) {
		if (a.esHoja()) {
			return suma + a.getDato();
		} 
		int hijoIzq = recorrer(suma+a.getDato(), a.getHijoIzquierdo());
		int hijoDer = recorrer(suma+a.getDato(), a.getHijoDerecho());
		return Math.max(hijoIzq, hijoDer);
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
		
		int num = retardoReenvio();
		System.out.println(num);

	}

}
