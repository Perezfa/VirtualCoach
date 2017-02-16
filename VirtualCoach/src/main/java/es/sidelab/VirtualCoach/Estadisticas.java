package es.sidelab.VirtualCoach;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Estadisticas {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String id_estadisticas;	
	private Date fecha;
	private float marca;
	private float grafico;
	
	public Estadisticas(){
		
	}
	public Estadisticas(String id_estadisticas, Date fecha, float marca, float grafico){
		
		this.id_estadisticas=id_estadisticas;
		this.fecha=fecha;
		this.marca=marca;
		this.grafico=grafico;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	public void setMarca(float marca){
		this.marca=marca;
	}
	public Date getFecha(){
		return fecha;
	}
	public float getMarca(){
		return marca;
	}
	public float dibujarGraficos(){
		return grafico;
		
	}
	public void setId_estadisticas(String id_estadisticas){
		
		this.id_estadisticas=id_estadisticas;
	}
	
	public String getId_estadisticas(){
		
		return id_estadisticas;
	}
}
