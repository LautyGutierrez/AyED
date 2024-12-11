package tests;
import tp02.ejercicio1.*;
public class TestListaEnterosConArreglo {
	public static void imprInversa(ListaDeEnteros l) {
		int num=l.tamanio();
		recu(l,num);
	}
	public static void recu(ListaDeEnteros l,int num) {
		if (num!=0) {
			System.out.println(l.elemento(num));
			recu(l,num=num-1);
		}
	}
	public static void main(String[] args) {
		ListaDeEnteros lista=new ListaDeEnterosConArreglos();
		lista.agregarFinal(1);
		lista.agregarInicio(4);
		lista.agregarFinal(7);
		lista.agregarFinal(10);
		lista.comenzar();
		while (!lista.fin()){
			System.out.println(lista.proximo());
		}
		imprInversa(lista);
	}

}