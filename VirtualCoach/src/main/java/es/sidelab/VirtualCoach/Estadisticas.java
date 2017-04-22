package es.sidelab.VirtualCoach;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Estadisticas {
	private String fecha;
	private long marca;
	private String ejercicio;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private long id_estadisticas;	
	
	@ManyToOne
	private Cliente cliente;
	
	public Estadisticas(){
		
	}


	public Estadisticas (long marca, String fecha, String ejercicio){
		this.marca=marca;
		this.fecha=fecha;
		this.ejercicio=ejercicio;

	}
	
	public String getFecha(){

		return fecha;
	}
	public long getMarca(){
		return marca;
	}
	public String getEjercicio(){
		return ejercicio;
	}
	

	public void setEjercicio(String ejercicio){
		this.ejercicio=ejercicio;
	}

	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public void setMarca(long marca){
		this.marca=marca;
	}
	public void setCliente(Cliente cliente){
		this.cliente=cliente;
	}
	public Cliente getCliente(){
		return cliente;
	}
	
	@Override
	public String toString(){
		return getCliente()+" "+ getFecha()+" "+getMarca()+" "+getEjercicio();
	}


}
