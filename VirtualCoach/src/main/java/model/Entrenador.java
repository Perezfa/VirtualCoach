package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
public class Entrenador extends Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_coach;
	//Un entrenador tiene varios clientes. Se guarda en cliente
	@OneToMany(mappedBy="entrenador")
	private List <Cliente> clientes;
	

	public Entrenador(){
		super();
	}
	public Entrenador(String nombre, String apellido, String edad,String rol ){
		super(nombre, apellido, edad, rol);
	}
	
	public long getId(){
		return id_coach;
	}

}
