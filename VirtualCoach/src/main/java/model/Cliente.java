package model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Cliente extends Usuario{
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
	private ArrayList<Estadisticas> estadisticas;
	
	public Cliente(){
		super();
	}
	public Cliente(String nombre, String apellido, String edad,String rol){
		super(nombre, apellido, edad, rol);
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
}
