package es.sidelab.VirtualCoach;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Estadisticas {
	private String fecha;
	private String marca;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_estadisticas;	
	
	@ManyToOne
	private Cliente cliente;
	
	public Estadisticas(){
		
	}


	public Estadisticas (String marca, String fecha){
		this.marca=marca;
		this.fecha=fecha;

	}
	
	public String getFecha(){
		return fecha;
	}
	public String getMarca(){
		return marca;
	}
	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public void setMarca(String marca){
		this.marca=marca;
	}
	public void setCliente(Cliente cliente){
		this.cliente=cliente;
	}
	public String getCliente(){
		return cliente.toString();
	}
	
	@Override
	public String toString(){
		return getCliente()+" "+ getFecha()+" "+getMarca();
	}

}
