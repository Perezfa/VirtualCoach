package es.sidelab.VirtualCoach;

import javax.persistence.*;

@Entity
public class Rutina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_rutina;
	
	private int repeticiones,series;
	private float peso;
	private String ejercicio;
	private String tipo;
	private int duracion;//semanas
	private float rm;
	

	public Rutina(){
		
	}
	
	public Rutina(String tipo,int id_entrenamiento,float peso,int repeticiones, int series, String ejercicio, int duracion, float rm){
		this.tipo=tipo;
		this.peso=peso;
		this.repeticiones=repeticiones;
		this.series=series;
		this.ejercicio=ejercicio;
		this.duracion=duracion;
		this.rm=rm;
	}
	public void setDuracion(int duracion){
		this.duracion=duracion;
	}
	public int getDuracion(){
		return duracion;
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	public String getTipo(){
		return tipo;
	}
	
	public void setPeso(float peso){
		this.peso=peso;
	}
	public void setRepeticiones(int repeticiones){
		this.repeticiones=repeticiones;
	}
	public void setSeries(int series){
		this.series=series;
	}
	public void setEjercicio(String ejercicio){
		this.ejercicio=ejercicio;
	}
	
	public float getPeso(){
		return peso;
	}
	public int getRepeticiones(){
		return repeticiones;
	}
	public int getSeries(){
		return series;
	}
	public String getEjercicio(){
		return ejercicio;
	}
	public void setRm(float rm){
		this.rm=rm;
	}
	public float getRm(){
		return rm;
	}
	public float calcularRm(){
		
		return rm;
	}

}
