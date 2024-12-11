package ejercicio5;
import tp06.ejercicio3.*;
import tp02.ejercicio2.*;
public class TestMapa {
	public static void main(String[] args){
		Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
		Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");

		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);

		ciudades.conectar(v1, v2,3); 
		ciudades.conectar(v1, v3,20);
		ciudades.conectar(v1, v4,4);
		ciudades.conectar(v1, v5,10);
		ciudades.conectar(v2, v5,50);
		ciudades.conectar(v2, v7,40);
		ciudades.conectar(v3, v5,4);
		ciudades.conectar(v4, v5,60);
		ciudades.conectar(v6, v5,11);
		ciudades.conectar(v6, v7,10);
		ciudades.conectar(v5, v7,10);
		
		Mapa m = new Mapa(ciudades);
		
		ListaGenerica<String> lis = m.devolverCamino("Buenos Aires","La Habana");
		System.out.println("--- Se imprime devolverCamino ---");
		lis.comenzar();
		if(lis.esVacia()) {
			System.out.println("La lista esta vacia");
		} else {
			while(!lis.fin()) {
				System.out.println(lis.proximo());
			}
		}
		
		ListaEnlazadaGenerica<String> exceptuando = new ListaEnlazadaGenerica<String>();
		exceptuando.agregarFinal("Santiago");
		exceptuando.agregarFinal("Lima");
		exceptuando.agregarFinal("Montevideo");
		ListaGenerica<String> lis2 = m.devolverCaminoExceptuando("Buenos Aires","La Habana",exceptuando);
		System.out.println("--- Se imprime devolverCaminoExceptuando ---");
		lis2.comenzar();
		if(lis2.esVacia()) {
			System.out.println("La lista esta vacia");
		} else {
			while(!lis2.fin()) {
				System.out.println(lis2.proximo());
			}
		}
		
		ListaGenerica<String> lis3 = m.caminoMasCorto("Buenos Aires","La Habana");
		System.out.println("--- Se imprime caminoMasCorto ---");
		lis3.comenzar();
		if(lis3.esVacia()) {
			System.out.println("La lista esta vacia");
		} else {
			while(!lis3.fin()) {
				System.out.println(lis3.proximo());
			}
		}
		
		ListaGenerica<String> lis4 = m.caminoSinCargarCombustible("Buenos Aires","La Habana",100);
		System.out.println("--- Se imprime caminoSinCargarCombustible ---");
		lis4.comenzar();
		if(lis4.esVacia()) {
			System.out.println("La lista esta vacia");
		} else {
			while(!lis4.fin()) {
				System.out.println(lis4.proximo());
			}
		}
		
		
		ListaGenerica<String> lis5 = m.caminoConMenorCargaDeCombustible("Buenos Aires","La Habana",39);
		System.out.println("--- Se imprime caminoConMenorCargaDeCombustible ---");
		lis5.comenzar();
		if(lis5.esVacia()) {
			System.out.println("La lista esta vacia");
		} else {
			while(!lis5.fin()) {
				System.out.println(lis5.proximo());
			}
		}

		
	}
}
