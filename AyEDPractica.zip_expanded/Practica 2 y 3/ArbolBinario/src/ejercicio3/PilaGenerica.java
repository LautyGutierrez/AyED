package tp02.ejercicio3;
import tp02.ejercicio2.*;
public class PilaGenerica<T> {
	private ListaGenerica<T> datos;
	public PilaGenerica() {
		datos=new ListaEnlazadaGenerica<T>();
	}
	public void apilar(T d) {
		datos.agregarInicio(d);
	}
	public T desapilar(){
		T elemento;
		datos.comenzar();
		elemento=datos.proximo();
		datos.eliminarEn(1);
		return elemento;
	}
	public T tope() {
		datos.comenzar();
		return datos.proximo();
	}
	public boolean esVacia() {
		return datos.esVacia();
	}
}
