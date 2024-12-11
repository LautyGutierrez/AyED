package tp02.ejercicio4.TestBalanceo;
import java.util.Scanner;
import tp02.ejercicio3.*;
import tp02.ejercicio2.*;
public class eje4b {
	public static boolean esBalanceado(String s) {
		int i,total=s.length();
		i=0;
		char c,d;
		boolean ok=true;
		PilaGenerica<Character> pila=new PilaGenerica<Character>();
		ListaGenerica<Character> apertura=new ListaEnlazadaGenerica<Character>();
		apertura.agregarFinal('{');
		apertura.agregarFinal('(');
		apertura.agregarFinal('[');
		
		ListaGenerica<Character> cierre=new ListaEnlazadaGenerica<Character>();
		cierre.agregarFinal('}');
		cierre.agregarFinal(')');
		cierre.agregarFinal(']');
		
		while ((ok)&&(i!=total)) {
			c=s.charAt(i);
			if (apertura.incluye(c)) {
				pila.apilar(c);
			}
			else if (cierre.incluye(c)) {
					d=pila.desapilar();
					if ((apertura.posicion(d))!=(cierre.posicion(c))) {
						ok=false;
					}
				}
			else {ok=false;}
			i++;
			}
		return ok;
		}
	
	public static void main(String[] args) {
		String s;
		Scanner e = new Scanner(System.in) ;
		System.out.println("Ingrese una cadena de caracteres");
		s=e.next();
		if (esBalanceado(s)) {
			System.out.println("Es balanceada");
		}
		else {
			System.out.println("No es balanceada");
		}
	}
}
