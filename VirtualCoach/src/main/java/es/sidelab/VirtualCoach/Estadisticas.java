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
	private Date fecha;
	private float marca;
	private float grafico;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Rutina> estadisticasRutina = new ArrayList<Rutina>();
	
	@Autowired
	

	public Estadisticas(long id_estadisticas, Date fecha, float marca, float grafico){
		this.id_estadisticas=id_estadisticas;
		this.fecha=fecha;
		this.marca=marca;
		this.grafico=grafico;
	}
	
	public Date getFecha(){
		return fecha;
	}
	public float getMarca(){
		return marca;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	public void setMarca(float marca){
		this.marca=marca;
	}
	
	public float dibujarGraficos(){
		return grafico;
		
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
	 
	
	
	 public static String getFechaActual() {
		 	Date actual = new Date();
	        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	        return formateador.format(actual);
	    }

}
