package model;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Estadisticas {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_estadisticas;
	
	private Date fecha;
	private float marca;
	private float grafico;
	
	public Estadisticas(){
		
	}
	public Estadisticas(Date fecha, float marca){
		this.fecha=fecha;
		this.marca=marca;
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
}
