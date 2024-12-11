package tests;
import tp02.ejercicio2.*;
import java.util.Scanner;
public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		ListaGenerica<Estudiante> lista=new ListaEnlazadaGenerica<Estudiante>();
		for (int i=1;i<=4;i++) {
			Estudiante e=new Estudiante();
			e.setApellido(s.nextLine());
			e.setNom(s.nextLine());
			e.setEmail(s.nextLine());
			e.setDireccion(s.nextLine());
			e.setComision(i);
			lista.agregarFinal(e);
		}
		
		lista.comenzar();
	
		while (!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
			
		}
		ListaGenerica<Estudiante> l=new ListaEnlazadaGenerica<Estudiante>();
		if (l.agregarTodos(lista)) {
			System.out.println("ok");
		}else System.out.println("not");
	}
	

}
