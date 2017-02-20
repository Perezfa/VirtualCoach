package es.sidelab.VirtualCoach;

import javax.annotation.PostConstruct;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VirtualCoachController {

	@Autowired
	private ClienteRepository cliente_repository;

	@GetMapping("/volver_inicio/{usuario}")
	public String inicio (Model model, @RequestParam String username){
		
		model.addAttribute("usuario",cliente_repository.findByUsuario(username).toString());
		return "dashboard";
	}
	@GetMapping("/calendario")
	public String calendario (Model model){
		return "calendar";
	}
	@GetMapping("/rating")
	public String rating (Model model){
		return "table";
	}
	
}
