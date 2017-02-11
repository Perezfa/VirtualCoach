package model;

public class Usuario {
	
	private String rol;
	private String nombre;
	private String apellido;
	private String edad;
	
	protected Usuario(){
		
	}
	
	public Usuario(String nombre, String apellido, String edad, String rol){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.rol=rol;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	public void setEdad(String edad){
		this.edad=edad;
	}
	public void setRol(String rol){
		this.rol=rol;
	}
	public String getRol(){
		return rol;
	}
	public String getNombre(){
		return nombre;
	}
	public String getEdad(){
		return edad;
	}
	public String getApellido(){
		return apellido;
	}
	


}
