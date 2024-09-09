package pe.mil.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.mil.entity.Calendario;
import pe.mil.service.CalendarioService;


@Controller
public class CalendarioController {
	@Autowired       //no le pongo el hijo para q pueda utilizar ambos
    private CalendarioService calService; //servira para cualkier hijo q defina en la configuracion
	
	@RequestMapping(value="/calendario_listar",method=RequestMethod.GET)
    public String listar_GET(Map map){        //Map permite enviar variables a una pagina web        
        map.put("baraja",calService.findAll());  
        return "/Calendario/Listar";   
    }
	
	@RequestMapping(value="/calendario_registrar",method=RequestMethod.GET)
    public String registrar_GET(Model model,Map map){        
        Calendario Model=new Calendario(); //vacio sus propiedades=null
        model.addAttribute("callen",Model);          
        return "/Calendario/Registrar";   
    }    
	@RequestMapping(value="/calendario_registrar",method=RequestMethod.POST)
    public String registrar_POST(Calendario cal){        //cal llega cargado al servidor  
		try {
			calService.insert(cal);
	        return "redirect:/calendario_listar";
		}
		catch(Exception ex) {
			return "redirect:/calen_errorborrar";
		}
    }    
	
	//la url se recibe mas corta:
		@RequestMapping(value="/cal_editar/{calId}",method=RequestMethod.GET) //llamado desde listar:recibe el id escogido
	    public String editar_GET(Model model,@PathVariable Integer calId,Map map){        
			Calendario calmod= calService.findById(calId); // esta cargado 
	        model.addAttribute("calen", calmod);    //envio auto completo	             
	        return "/Calendario/Editar";   
	    }
	
		@RequestMapping(value="/cal_editar/{calId}",method=RequestMethod.POST) 
	    public String editar_POST(Calendario calen){  	
			try {
				calService.update(calen);
		        return "redirect:/calendario_listar";  
			}
			catch(Exception ex) {
				return "redirect:/calen_errorborrar";
			}
	    }
		
		@RequestMapping(value="/calen_borrar/{calId}",method=RequestMethod.GET) //llamado desde listar:recibe el id del auto escogido
	    public String borrar_GET(Model model,@PathVariable Integer calId){        
			Calendario automod=calService.findById(calId); //automod esta cargado con el pro completo
	        model.addAttribute("calen", automod);//"calen" va a viajar a la pag.borrar
	        return "/Calendario/Borrar";   
	    }
	    @RequestMapping(value="/calen_borrar/{calId}",method=RequestMethod.POST) 
	    public String borrar_POST(Calendario calendario,@PathVariable Integer calId){          
	        //antes de borrar busca en el hijo Pago para lanzar error
	    	ArrayList<Integer> listado= (ArrayList<Integer>) calService.calID_CalPago();
			for (Integer calid: listado  ) {
			if (calid==calId)
				return "redirect:/calen_errorborrar";
			}  	    	
	    	//uso el id del calen recibido como clave del dicc
	        calService.delete(calendario.getId());        
	        return "redirect:/calendario_listar";   
	    }
		
	    @RequestMapping(value="/calen_errorborrar",method=RequestMethod.GET)
	    public String caerrorborrar_GET(){ 
			return "/Calendario/ErrorBorrar";   
	    }    
	    
	    
	    
	    
}
