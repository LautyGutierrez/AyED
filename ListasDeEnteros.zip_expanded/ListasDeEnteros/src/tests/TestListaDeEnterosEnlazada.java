package tests;
import tp02.ejercicio1.*;

import java.util.Scanner;
public class TestListaDeEnterosEnlazada {
	public static void imprInversa(ListaDeEnteros l ) {
		
		int num=l.tamanio();
		recu(l,num);
		
	}
	public static void recu(ListaDeEnteros l, int num) {
		if (num!=0) {
			System.out.println(l.elemento(num));
			recu(l,num-1);
		}
	}
	public static void sucesionNum(int num) {
		int total=0;
		if (num!=1){
			if ((num % 2)==0) {
				total=num/2;
				System.out.println(total);
			
			}
			else {
				total=(3*num)+1;
				System.out.println(total);
			}
			sucesionNum(total);
		}
	}
	public static void main(String[] args) {
		ListaDeEnteros lista=new ListaDeEnterosEnlazada();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		while (n!=0) {
			lista.agregarFinal(n);
			n=s.nextInt();
		}
		lista.comenzar();
		while(!(lista.fin())) {
			System.out.println(lista.proximo());
		}
		
	}

}
