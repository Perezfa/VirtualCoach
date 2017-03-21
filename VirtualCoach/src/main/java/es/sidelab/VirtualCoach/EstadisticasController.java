package es.sidelab.VirtualCoach;




import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class EstadisticasController {
	@Autowired 
	private EstadisticasRepository estadisticas_repository;
	@Autowired
	private ClienteRepository cliente_repository;


	/*
	@PostMapping("/añadirestadisticas")
	public String nuevaEstadisticaCliente(Model model, Estadisticas estadistica, HttpSession sesion){
		
		//Username, no nombre real
		String usuario= (String) sesion.getAttribute("user");
		Cliente cliente=cliente_repository.findByUsuario(usuario);
		//A la estadistica le metemos el Id del usuario
		estadistica.setCliente(cliente);
		
		estadisticas_repository.save(estadistica);
		model.addAttribute("estadistica",estadistica);
		
		return "estadisticas_añadidas";
	}*/
	
	@RequestMapping("/eliminar_estadisticas")
	public String eliminarArticulo (Model model, @PathVariable long id_estadisticas ){
		
		Estadisticas estadisticas = estadisticas_repository.findOne(id_estadisticas);
		estadisticas_repository.delete(estadisticas);
		model.addAttribute("estadisticas", estadisticas_repository.findAll());
		return "estadisticas_eliminadas";
	}
	
	/*
	 * Método altenativo para mostrar estadísticas a la derecha nada mas añadirlas, sin mostrar 
	 * la pantalla de "estadisticas añadidas" sino que se meustren directamente todas al añadir una nueva
	 */
	
	@PostMapping("/añadirestadisticas")
	public String AñadirEstadistica(Model model, Estadisticas estadistica, HttpSession sesion){
		
		//Username, no nombre real
		String usuario= (String) sesion.getAttribute("user");
		Cliente cliente=cliente_repository.findByUsuario(usuario);
		//A la estadistica le metemos el Id del usuario
		estadistica.setCliente(cliente);
		//Guardamos la nueva estadistica
		estadisticas_repository.save(estadistica);
		
		model.addAttribute("estadistica",estadistica);
		
		return "estadisticas_añadidas";
	}
		
		@PostMapping("/mostrarestadistica")
		public String MostrarEstadistica(Model model, Estadisticas estadistica, HttpSession sesion){
			//Buscamos todas las estadisticas de ese usuario
			String usuario= (String) sesion.getAttribute("user");
			Cliente cliente=cliente_repository.findByUsuario(usuario);
			List<Estadisticas> estadisticas_user=estadisticas_repository.findByCliente(cliente);
			model.addAttribute("estadistica",estadistica);
		
			return "dashboard";

	}
	
	
	
	
	
	

}
