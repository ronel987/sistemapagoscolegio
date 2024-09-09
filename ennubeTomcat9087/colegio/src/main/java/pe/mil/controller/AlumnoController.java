package pe.mil.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.mil.entity.Alumno;
import pe.mil.service.AlumnoService;
import pe.mil.service.ApoderadoService;
import pe.mil.service.UsuarioService;

@Controller
public class AlumnoController {
	@Autowired       
    private ApoderadoService apoService;
	
	@Autowired
	private AlumnoService alService;

	@RequestMapping(value="/alumno_listar",method=RequestMethod.GET)
    public String listar_GET(Map map){       
        map.put("baraja",alService.findAll());  
        return "/Alumno/Listar";   
    }
	
	@RequestMapping(value="/alumno_registrar",method=RequestMethod.GET)
    public String registrar_GET(Model model,Map map){        
		Alumno Model=new Alumno(); 
        model.addAttribute("alumno",Model);
        map.put("bApoderado",apoService.findAll());
        return "/Alumno/Registrar";   
    }    
	@RequestMapping(value="/alumno_registrar",method=RequestMethod.POST)
    public String registrar_POST(Alumno alumno){
		try {
			alService.insert(alumno);
	        return "redirect:/alumno_listar";				
		} catch (Exception e) {
			return "redirect:/alumno_errorborrar";
		}	
         
    }    
	
		@RequestMapping(value="/alumno_editar/{Id}",method=RequestMethod.GET) 
	    public String editar_GET(Model model,@PathVariable Integer Id,Map map){        
			Alumno alumod= alService.findById(Id);
	        model.addAttribute("alumno", alumod);
	        map.put("bApoderado",apoService.findAll());
	        return "/Alumno/Editar";   
	    }
	
		@RequestMapping(value="/alumno_editar/{Id}",method=RequestMethod.POST) 
	    public String editar_POST(Alumno alumno){  
			try {
				alService.update(alumno);
		        return "redirect:/alumno_listar";				
			} catch (Exception e) {
				return "redirect:/alumno_errorborrar";
			}	
			 
	    }
		
		@RequestMapping(value="/alumno_borrar/{Id}",method=RequestMethod.GET)
	    public String borrar_GET(Model model,@PathVariable Integer Id){  
			
			Alumno alummod=alService.findById(Id); 
	        model.addAttribute("alumno", alummod);
	        return "/Alumno/Borrar";   
	    }
	    @RequestMapping(value="/alumno_borrar/{Id}",method=RequestMethod.POST) 
	    public String borrar_POST(Alumno alumno,@PathVariable Integer Id){ 
	    	try {
	    		alService.delete(alumno.getId());        
		        return "redirect:/alumno_listar";				
			} catch (Exception e) {
				//ArrayList<Integer> listado= (ArrayList<Integer>) alService.aluID_AluMatricula();
				return "redirect:/alumno_errorborrar";
			}
			   
	    }
	    
	    @RequestMapping(value="/alumno_errorborrar",method=RequestMethod.GET)
	    public String alumnoerrorborrar_GET(){ 
			return "/Alumno/ErrorBorrar";   
	    } 
}
