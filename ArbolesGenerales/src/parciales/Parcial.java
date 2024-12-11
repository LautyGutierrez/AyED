package parciales;
import tp04.ejercicio1.*;
public class Parcial {
	public static boolean esDeSeleccion (ArbolGeneral<Integer> arbol){
		boolean ok = false;
		if (!arbol.esVacio()){
			ok = comprobarEsDeSeleccion(arbol);
		 }
		 return ok;
	}

	private static boolean comprobarEsDeSeleccion (ArbolGeneral<Integer> arbol){
		boolean ok = true;
		int min = Integer.MAX_VALUE;
		if(arbol.tieneHijos()){
			arbol.getHijos().comenzar();
		    ArbolGeneral<Integer> hijo;
		    while ((!arbol.getHijos().fin()) && (ok)){
		    	hijo = arbol.getHijos().proximo();
		    	min = Math.min(min, hijo.getDato());
		    	if(arbol.getDato() > hijo.getDato()){
		    		ok = false;
		        } else {
		          	ok = comprobarEsDeSeleccion(hijo);
		        }
		    }
		    if (arbol.getDato() != min){
		      ok = false;
		    }
		}
		return ok;
	} 
	//---------------------------------------------------------------------------------------------------------//
	
	
}
