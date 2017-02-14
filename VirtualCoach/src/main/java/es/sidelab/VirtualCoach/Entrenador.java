package es.sidelab.VirtualCoach;

import java.util.List;

import javax.persistence.*;



@Entity
public class Entrenador{
	private String rol;
	private String nombre;
	private String apellido;
	private String edad;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_coach;
	//Un entrenador tiene varios clientes. Se guarda en cliente
	@OneToMany(mappedBy="entrenador")
	private List <Cliente> clientes;
	

	public Entrenador(){
	}
	public Entrenador(String nombre, String apellido, String edad, String rol){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.rol=rol;
		
	}
	
	public long getId(){
		return id_coach;
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
