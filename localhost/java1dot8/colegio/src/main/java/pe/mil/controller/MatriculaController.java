package pe.mil.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.mil.entity.Matricula;
import pe.mil.service.AlumnoService;
import pe.mil.service.Ano_EscolarService;
import pe.mil.service.ApoderadoService;
import pe.mil.service.MatriculaService;

@Controller
public class MatriculaController {
	

	
	@Autowired
	private AlumnoService alService;
	
	@Autowired
	private MatriculaService maService;
	
	@Autowired
	private Ano_EscolarService ano_escolarService;
	
	@RequestMapping(value="/matricula_listar",method=RequestMethod.GET)
    public String listar_GET(Map map){
        map.put("baraja",maService.findAll());
        return "/Matricula/Listar";
    }
	
	@RequestMapping(value="/matricula_registrar",method=RequestMethod.GET)
    public String registrar_GET(Model model,Map map){        
		Matricula Model=new Matricula(); 
        model.addAttribute("matricula",Model);
        map.put("baraja",alService.findAll());
        map.put("bAno_Escolar",ano_escolarService.findAll());
        return "/Matricula/Registrar";   
    }    
	@RequestMapping(value="/matricula_registrar",method=RequestMethod.POST)
    public String registrar_POST(Matricula matricula, Map map){
		maService.insert(matricula);
		map.put("matriok", "Se Insertó una Matrícula");
        return "redirect:/matricula_listar";   
    }    
	
		@RequestMapping(value="/matricula_editar/{Id}",method=RequestMethod.GET) 
	    public String editar_GET(Model model,@PathVariable Integer Id,Map map){        
			Matricula matmod= maService.findById(Id); 
	        model.addAttribute("matricula", matmod); 
	        map.put("baraja",alService.findAll());
	        map.put("bAno_Escolar",ano_escolarService.findAll());
	        return "/Matricula/Editar";   
	    }
	
		@RequestMapping(value="/matricula_editar/{Id}",method=RequestMethod.POST) 
	    public String editar_POST(Matricula matricula){  						
			maService.update(matricula);
	        return "redirect:/matricula_listar";   
	    }
		
		@RequestMapping(value="/matricula_borrar/{Id}",method=RequestMethod.GET) 
	    public String borrar_GET(Model model,@PathVariable Integer Id){        
			Matricula matrmod=maService.findById(Id); 
	        model.addAttribute("matricula", matrmod);
	        return "/Matricula/Borrar";   
	    }
	    @RequestMapping(value="/matricula_borrar/{Id}",method=RequestMethod.POST) 
	    public String borrar_POST(Matricula matricula,@PathVariable Integer Id){          
			maService.delete(matricula.getId());        
	        return "redirect:/matricula_listar";   
	    }

}
