package tests;
import tp02.ejercicio1.*;
public class Ejercicio1_6main {
	public ListaDeEnterosEnlazada calcularSucesion (int num) {
		ListaDeEnterosEnlazada lista=new ListaDeEnterosEnlazada();
		sucesionNum(lista,num);
		return lista;
	}
	public  void sucesionNum(ListaDeEnterosEnlazada l, int num) {
		int total=0;
		if (num!=1){
			if ((num % 2)==0) {
				total=num/2;
			}
			else {
				total=(3*num)+1;
			}
			l.agregarFinal(total);
			sucesionNum(l,total);
		}
		
	}
	public static void main(String[] args) {
		Ejercicio1_6main f= new Ejercicio1_6main();
		ListaDeEnterosEnlazada l=f.calcularSucesion(4);
		l.comenzar();
		while (!l.fin()){
			System.out.println(l.proximo());
		}
	}
}
