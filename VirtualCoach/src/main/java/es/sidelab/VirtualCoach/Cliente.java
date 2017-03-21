package es.sidelab.VirtualCoach;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cliente {
	private ArrayList<String> rol;
	private String usuario;
	private String nombre;
	private String apellido;
	private String email;
	private String edad;
	private String contraseña;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_cliente;
	
	//Un cliente solo tiene un entrenador, pero un entrenador n clientes
	@ManyToOne
	private Entrenador entrenador;
	
	//Un cliente solo tiene 1 rutina, pero 1 rutina n clientes
	@ManyToOne(cascade=CascadeType.ALL)
	private Rutina rutina;
	
	//Si borramos un cliente se borran sus estadisticas.
	@OneToMany(cascade=CascadeType.ALL)
	private List<Estadisticas> estadisticas;
	



	public Cliente(){
		
	}

	public Cliente(String nombre,String apellido, String usuario, String email, String edad,String contraseña, String rol, Entrenador entrenador ){
		this.nombre=nombre;
		this.apellido=apellido;
		this.usuario=usuario;

		this.email=email;
		this.edad=edad;
		this.contraseña=contraseña;
		this.rol = new ArrayList<String>();
		if(rol!=null){
			this.rol.add(rol);
		}
		this.entrenador=entrenador;
		
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	} 
	
	public long getId(){
		return id_cliente;
	}
	public void setRutina(Rutina rutina){
		this.rutina=rutina;
	}
	public Rutina getRutina(){
		return rutina;
	}
	public void setEntrenador(Entrenador entrenador){
		this.entrenador=entrenador;
	}
	public Entrenador getEntrenador(){
		return entrenador;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public void setApellido(String apellido){
		this.nombre=apellido;
	}
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}
	public String getUsuario(){
		return usuario;
	}
	

	public void setContraseña(String contraseña){
		this.contraseña=contraseña;
	}
	
	public void setEdad(String edad){
		this.edad=edad;
	}
	public void setRol(ArrayList<String> rol){
		this.rol=rol;
	}
	public ArrayList<String> getRol(){
		return rol;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public String getEdad(){
		return edad;
	}
	public String getContraseña(){
		return contraseña;
	}
	


	@Override
	public String toString(){
		return getUsuario();

	}
}