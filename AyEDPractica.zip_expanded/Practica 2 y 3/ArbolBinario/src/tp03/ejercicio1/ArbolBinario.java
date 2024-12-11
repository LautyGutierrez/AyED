package tp03.ejercicio1;
import ejercicio3.*;
public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		if (this.esVacio()){
    	return 0;
    } else if (this.esHoja()){
    	return 1;
    } else{
    		int contar=0; 
    		int contar2=0;
        if (this.tieneHijoIzquierdo()){
    			contar = this.getHijoIzquierdo().contarHojas() ;}
    		if (this.tieneHijoDerecho()){
        	contar2=this.getHijoDerecho().contarHojas();

		}
		return contar + contar2;
    }
	}
	

  /*  public ArbolBinario<T> espejo() {
			if (this.esVacio ()){
      	return null;
      } else {
      	ArbolBinario<T> a = new ArbolBinario<T>();
        ColaGenerica<T> c = new ColaGenerica<T>();
        c.encolar(this);
        a = c.desencolar;
        generarArbol(a,c);
        return a;
      }
    private static generarArbol(ArbolBinario<T> a, ColaGenerica<T> c){
    	if !(a.esHoja){
      	c.encolar(a.getHijoHijoIzquierdo);
      	c.encolar(a.getHijoDerecho);
      	a.agregarHijoDerecho(c.desencolar);
      	a.agregarHijoIzquierdo(c.desencolar);
      	if (a.tieneHijoIzquierdo){
      		generarArbol(a.getHijoIzquierdo);
      	}
      	if (a.tieneHijoDerecho){
      		generarArbol(a.getHijoDerecho);
      	}
      }
    }*/
    
  
    public ArbolBinario<T> espejo2(){
    	if (!this.esVacio()){
      	return sacarArbol();
      }
      else return null;
    }
    
    private ArbolBinario<T> sacarArbol(){
    	ArbolBinario<T> a = new ArbolBinario<T>(this.getDato());
      
      if (this.tieneHijoIzquierdo()){
      	a.agregarHijoDerecho(this.getHijoIzquierdo().sacarArbol());
      }
      if (this.tieneHijoDerecho()){
      	a.agregarHijoIzquierdo(this.getHijoDerecho().sacarArbol());
      }
    	return a;
    }
	
	


	public void entreNiveles(int n, int m){
  	ArbolBinario<T> arbol=null;
    ColaGenerica<ArbolBinario<T>> cola=new ColaGenerica<ArbolBinario<T>>();
    cola.encolar(this);
    cola.encolar(null);
    int nivel = 0;
    while ((!cola.esVacia()) && (nivel<=m)){
    	arbol=cola.desencolar();
      if (arbol!=null){
      	if(nivel >= n){
      	System.out.print(arbol.getDato());
        }
        if(arbol.tieneHijoIzquierdo()){
        	cola.encolar(arbol.getHijoIzquierdo());
        }
        if (arbol.tieneHijoDerecho()){
        	cola.encolar(arbol.getHijoDerecho());
        }
        
      } else if (!cola.esVacia()){
      	System.out.println();
        nivel++;
        cola.encolar(null);
      }
    }
	}

	

}