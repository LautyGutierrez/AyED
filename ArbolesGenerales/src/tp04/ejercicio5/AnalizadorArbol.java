package tp04.ejercicio5;
import tp04.ejercicio1.*;
import tp02.ejercicio3.*;
public class AnalizadorArbol {
	public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		int max;
		if (arbol.esVacio()) max = -1;
		else {
			int promedio;
			max = 0;
			ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
			ArbolGeneral<AreaEmpresa> a = new ArbolGeneral<>(null);
			int cant = 0, suma = 0;
			cola.encolar(arbol);
			cola.encolar(null);
			while(!cola.esVacia()) {
				a = cola.desencolar();
				if (a != null) {
					suma += a.getDato().getTardanza();
					cant += 1;
					if(a.tieneHijos()) {
						a.getHijos().comenzar();
						while(!a.getHijos().fin()) {
							cola.encolar(a.getHijos().proximo());
						}
					}
				} else if(!cola.esVacia()) {
					cola.encolar(null);
					promedio = suma / cant;
					max = Math.max(max, promedio);
					cant = 0;
					suma = 0;
				}
			}
			max = Math.max(max, suma/cant);
		}
		return max;
	}
}
