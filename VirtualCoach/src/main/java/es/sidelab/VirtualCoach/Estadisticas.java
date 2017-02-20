package es.sidelab.VirtualCoach;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Estadisticas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_estadisticas;
	
	private String fecha;
	private float marca;
	private String ejercicio;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Rutina> estadisticasRutina = new ArrayList<Rutina>();
	
	@Autowired
	

	public Estadisticas(String fecha, float marca,String ejercicio){
		this.fecha=fecha;
		this.marca=marca;
		this.ejercicio=ejercicio;
	
	}
	
	public String getFecha(){
		return fecha;
	}
	public float getMarca(){
		return marca;
	}
	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	public void setMarca(float marca){
		this.marca=marca;
	}
	

	public void setId_estadisticas(long id_estadisticas){

		this.id_estadisticas=id_estadisticas;
	}
		

	public long getId_estadisticas(){
		
		return id_estadisticas;
	}
	
	
	public List<Rutina> getEstadisticasRutina(){
		
		return estadisticasRutina;
	}
	 public void setEstadisticasRutina(List <Rutina> estadisticasRutina){
		 
		 	this.estadisticasRutina= estadisticasRutina;
	 }
	 
	
	
	 public String getFechaActual() {
		 	Date actual = new Date();
	        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	        return formateador.format(actual);
	    }

}
