package pe.mil.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.mil.entity.Apoderado;
import pe.mil.service.ApoderadoService;


@Controller
public class ApoderadoController {
	
	@Autowired
	private ApoderadoService apoService;
	
	@RequestMapping(value="/apoderado_listar",method=RequestMethod.GET)
    public String listar_GET(Map map){         
        map.put("baraja",apoService.findAll());  
        return "/Apoderado/Listar";
    }
	
	@RequestMapping(value="/apoderado_registrar",method=RequestMethod.GET)
    public String registrar_GET(Model model,Map map){        
        Apoderado Model=new Apoderado(); 
        model.addAttribute("apoderado",Model);          
        return "/Apoderado/Registrar";   
    }    
	@RequestMapping(value="/apoderado_registrar",method=RequestMethod.POST)
    public String registrar_POST(Apoderado apoderado){  
		try {
			apoService.insert(apoderado);
			return "redirect:/apoderado_listar";  
		}
		catch(Exception ex) {
			return "redirect:/apo_errorborrar";
		}
    }    
	
		@RequestMapping(value="/apo_editar/{Dni}",method=RequestMethod.GET) 
	    public String editar_GET(Model model,@PathVariable Integer Dni,Map map){        
			Apoderado apomod= apoService.findById(Dni);
	        model.addAttribute("apoderado", apomod);               
	        return "/Apoderado/Editar";   
	    }
	
		@RequestMapping(value="/apo_editar/{Dni}",method=RequestMethod.POST) 
	    public String editar_POST(Apoderado apoderado){  
			try {
				apoService.update(apoderado);
				return "redirect:/apoderado_listar";   
			}
			catch(Exception ex) {
				return "redirect:/apo_errorborrar";
			}
	    }
		
		@RequestMapping(value="/apo_borrar/{Dni}",method=RequestMethod.GET) 
	    public String borrar_GET(Model model,@PathVariable Integer Dni){        
			Apoderado automod=apoService.findById(Dni); 
	        model.addAttribute("apoderado", automod);
	        return "/Apoderado/Borrar";   
	    }
	    @RequestMapping(value="/apo_borrar/{Dni}",method=RequestMethod.POST) 
	    public String borrar_POST(Apoderado apoderado,@PathVariable Integer Dni){
	    	try {
	    		apoService.delete(apoderado.getDni());        
		        return "redirect:/apoderado_listar"; 
				
			} catch (Exception e) {
				//ArrayList<Integer> listado= (ArrayList<Integer>) apoService.Dni_ApoAlu();
				return "redirect:/apo_errorborrar";
			}
		}  	    	
	    
	    @RequestMapping(value="/apo_errorborrar",method=RequestMethod.GET)
	    public String apoerrorborrar_GET(){ 
			return "/Apoderado/ErrorBorrar";   
	    }    
	    
}

