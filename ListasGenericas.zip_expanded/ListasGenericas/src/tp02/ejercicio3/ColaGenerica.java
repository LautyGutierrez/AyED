package tp02.ejercicio3;
import tp02.ejercicio2.*;
public class ColaGenerica<T> {
	private ListaGenerica<T> datos;
	public ColaGenerica(){
		datos=new ListaEnlazadaGenerica<T>();
	}
	public void encolar(T d) {
		datos.agregarFinal(d);
	}
	public T desencolar() {
		T elem;
		datos.comenzar();
		elem=datos.proximo();
		datos.eliminarEn(1);
		return elem;
	}
	public T tope() {
		datos.comenzar();
		return datos.proximo();
		
	}
	public boolean esVacia() {
		datos.comenzar();
		return datos.esVacia();
	}
}

