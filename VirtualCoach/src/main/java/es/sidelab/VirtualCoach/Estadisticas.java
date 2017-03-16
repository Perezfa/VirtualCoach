package es.sidelab.VirtualCoach;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
=======
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3

import javax.persistence.*;

@Entity
public class Estadisticas {
	private String fecha;
	private String marca;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
<<<<<<< HEAD

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
=======
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
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3
		return fecha;
	}
	public String getMarca(){
		return marca;
	}
	
<<<<<<< HEAD
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
=======
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
>>>>>>> 31c133c79686a4805599892cd358bc0ceea562c3

}
