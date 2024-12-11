package tp04.ejercicio7;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
public class RedDeAguaPotable {
	static ArbolGeneral<String> red;
	
	public void setRed (ArbolGeneral<String> red) {
		this.red = red;
	}
	
	public static double minimoCaudal(double caudal) {
		double min;
		if (red.esVacio()) {
			min = -1;
		} else {
			min = calcularMinimoCaudal(caudal, red);
		}
		return min;
	}
	
	private static double calcularMinimoCaudal(double caudal, ArbolGeneral<String> arbol) {
		double caudalMin = caudal;
		if (arbol.tieneHijos()) {
			int cantHijos = arbol.getHijos().tamanio();
			double caudalActual = caudal/cantHijos;
			arbol.getHijos().comenzar();
			while (!arbol.getHijos().fin()) {
				ArbolGeneral<String> hijo = arbol.getHijos().proximo();
				if (!hijo.esHoja()) {
					caudalMin = Math.min(calcularMinimoCaudal(caudalActual, hijo), caudalActual);
				}
			}
		}
		return caudalMin;
	}
	
	
	
	public static void main(String[] args) {
		ArbolGeneral<String> a = new ArbolGeneral<>("raiz");
		
		ArbolGeneral<String> b = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> c = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> d = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> e = new ArbolGeneral<>("raiz");
		
		ArbolGeneral<String> f = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> g = new ArbolGeneral<>("raiz");
		
		ArbolGeneral<String> h = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> i = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> j = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> k = new ArbolGeneral<>("raiz");
		
		ArbolGeneral<String> l = new ArbolGeneral<>("raiz");
		
		ArbolGeneral<String> m = new ArbolGeneral<>("raiz");
		ArbolGeneral<String> n = new ArbolGeneral<>("raiz");
		
		j.agregarHijo(m);
		j.agregarHijo(n);
		
		d.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);
		d.agregarHijo(k);
		
		g.agregarHijo(l);
		
		c.agregarHijo(f);
		c.agregarHijo(g);
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		a.agregarHijo(e);
		
		red = a;
		double algo = minimoCaudal(1000);
		System.out.println(algo);
		
		
	}
}
