package es.sidelab.VirtualCoach;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Estadisticas {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	

	private int id_estadisticas;	

	private Date fecha;
	private float marca;
	private float grafico;
	
	@Autowired
	
	public Estadisticas(int id_estadisticas, Date fecha, float marca, float grafico){


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

	public void setId_estadisticas(int id_estadisticas){


		
		this.id_estadisticas=id_estadisticas;
	}
	

	public int getId_estadisticas(){
		
		return id_estadisticas;
	}
	 public static String getFechaActual() {
		 	Date actual = new Date();
	        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	        return formateador.format(actual);
	    }

}
