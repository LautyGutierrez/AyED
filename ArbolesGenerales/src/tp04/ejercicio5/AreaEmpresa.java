package tp04.ejercicio5;

public class AreaEmpresa {
	public String area;
	public int tardanza;
	
	public AreaEmpresa() {}
	
	public AreaEmpresa(String area, int tardanza) {
		this.area = area;
		this.tardanza = tardanza;
	}
	
	public void setTardanza(int t) {
		tardanza = t;
	}
	
	public int getTardanza() {
		return tardanza;
	}
	
	public void setArea(String a) {
		area = a;
	}
	
	public String getArea() {
		return area;
	}
}
