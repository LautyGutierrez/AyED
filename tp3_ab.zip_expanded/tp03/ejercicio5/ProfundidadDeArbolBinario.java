package tp03.ejercicio5;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;
public class ProfundidadDeArbolBinario {
		static ArbolBinario<Integer> a; 
		
		public static int sumaElementosProfundidad(int prof) {
			ArbolBinario<Integer> arbol=null;
		    ColaGenerica<ArbolBinario<Integer>> cola=new ColaGenerica<ArbolBinario<Integer>>();
		    cola.encolar(a);
		    cola.encolar(null);
		    int suma = 0;
		    int nivel = 0;
		    while ((!cola.esVacia()) && (nivel <= prof)){
		    	arbol=cola.desencolar();
		      if (arbol!=null){
		      	if(nivel == prof) {
		      		suma = suma + arbol.getDato();
		      	 }
		        if(arbol.tieneHijoIzquierdo()){
		        	cola.encolar(arbol.getHijoIzquierdo());
		        }
		        if (arbol.tieneHijoDerecho()){
		        	cola.encolar(arbol.getHijoDerecho());
		        }
		        
		      } else if (!cola.esVacia()){
		        nivel++;
		        cola.encolar(null);
		      }
		    }
		    return suma;
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
			
			int total = sumaElementosProfundidad(2);
			System.out.println(total);
		}

	}
