package parciales;

import tp04.ejercicio1.ArbolGeneral;

public class TestParciales {
	public static void main(String[] args) {
	//raiz
	ArbolGeneral<Integer> a = new ArbolGeneral<>(12);
	//hijos de la raiz
	ArbolGeneral<Integer> b = new ArbolGeneral<>(12);
	ArbolGeneral<Integer> c = new ArbolGeneral<>(25);
	//hijos del arbol b
	ArbolGeneral<Integer> d = new ArbolGeneral<>(12);
	ArbolGeneral<Integer> e = new ArbolGeneral<>(35);
	//hijo del arbol e
	ArbolGeneral<Integer> f = new ArbolGeneral<>(35);
	//hijo del arbol f
	ArbolGeneral<Integer> g = new ArbolGeneral<>(35);
	//hijos del arbol d
	ArbolGeneral<Integer> h = new ArbolGeneral<>(14);
	ArbolGeneral<Integer> i = new ArbolGeneral<>(12);
	ArbolGeneral<Integer> j = new ArbolGeneral<>(33);
	//hijos del arbol j
	ArbolGeneral<Integer> k = new ArbolGeneral<>(35);
	ArbolGeneral<Integer> l = new ArbolGeneral<>(83);
	ArbolGeneral<Integer> m = new ArbolGeneral<>(90);
	ArbolGeneral<Integer> n = new ArbolGeneral<>(33);
	
	j.agregarHijo(k);
	j.agregarHijo(l);
	j.agregarHijo(m);
	j.agregarHijo(n);
	
	d.agregarHijo(h);
	d.agregarHijo(i);
	d.agregarHijo(j);
	
	f.agregarHijo(g);
	
	e.agregarHijo(f);
	
	b.agregarHijo(d);
	b.agregarHijo(e);
	
	a.agregarHijo(b);
	a.agregarHijo(c);
	
	boolean algo = Parcial.esDeSeleccion(a);
	System.out.println(algo);
	}
}
