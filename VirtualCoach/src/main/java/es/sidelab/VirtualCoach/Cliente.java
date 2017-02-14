package es.sidelab.VirtualCoach;

import java.util.List;

import javax.persistence.*;

@Entity
public class Cliente {
	private String rol;
	private String nombre;
	private String apellido;
	private String edad;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_cliente;
	
	//Un cliente solo tiene un entrenador, pero un entrenador n clientes
	@ManyToOne
	private Entrenador entrenador;
	
	//Un cliente solo tiene 1 rutina, pero 1 rutina n clientes
	@ManyToOne
	private Rutina rutina;
	
	//Si borramos un cliente se borran sus estadisticas.
	@OneToMany(cascade=CascadeType.ALL)
	private List<Estadisticas> estadisticas;
	
	public Cliente(){
		
	}
	public Cliente(String nombre, String apellido, String edad, String rol){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.rol=rol;
		
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
	public Entrenador mostrarEntrenador(){
		return entrenador;
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
	

	@Override
	public String toString(){
		return "Cliente: "+getNombre()+" "+getApellido();
	}
}