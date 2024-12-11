package tests;

public class Estudiante {
	private String nom;
	private String apellido;
	private int comision;
	private String email;
	private String direccion;
	public Estudiante() {}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String tusDatos() {
		return getNom()+getApellido()+getComision()+ getEmail()+getDireccion();
	}
}
