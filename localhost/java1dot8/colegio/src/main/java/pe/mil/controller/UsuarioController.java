package pe.mil.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.mil.entity.Usuario;

import pe.mil.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired       //no le pongo el hijo para q pueda utilizar ambos
    private UsuarioService usuService; //servira para cualkier hijo q defina en la configuracion
	
	@RequestMapping(value="/usuario_listar",method=RequestMethod.GET)
    public String listar_GET(Map map){        //Map permite enviar variables a una pagina web        
        map.put("baraja",usuService.findAll());  
        return "/Usuario/Listar";   
    }
	
	@RequestMapping(value="/usuario_registrar",method=RequestMethod.GET)
    public String registrar_GET(Model model,Map map){        
		Usuario mod=new Usuario(); //vacio sus propiedades=null
        model.addAttribute("usua",mod);          
        return "/Usuario/Registrar";   
    }    
	@RequestMapping(value="/usuario_registrar",method=RequestMethod.POST)
    public String registrar_POST(Usuario usuario){        // llega cargado al servidor  
		try {
			usuService.insert(usuario);
	        return "redirect:/usuario_listar"; 
		}
		catch(Exception ex) {
			return "redirect:/usu_errorborrar";
		}
    }    
	
	//la url se recibe mas corta:
		@RequestMapping(value="/usu_editar/{calId}",method=RequestMethod.GET) //llamado desde listar:recibe el id escogido
	    public String editar_GET(Model model,@PathVariable Integer calId,Map map){        
			Usuario calmod= usuService.findById(calId); // esta cargado 
	        model.addAttribute("usuario", calmod);    //envio auto completo	             
	        return "/Usuario/Editar";   
	    }
	
		@RequestMapping(value="/usu_editar/{calId}",method=RequestMethod.POST) 
	    public String editar_POST(Usuario usuario){  
			try {
				usuService.update(usuario);
		        return "redirect:/usuario_listar"; 
			}
			catch(Exception ex) {
				return "redirect:/usu_errorborrar";
			}
					          
	    }
		
		@RequestMapping(value="/usu_borrar/{calId}",method=RequestMethod.GET) //llamado desde listar:recibe el id del auto escogido
	    public String borrar_GET(Model model,@PathVariable Integer calId){        
			Usuario automod=usuService.findById(calId); //automod esta cargado con el pro completo
	        model.addAttribute("usuario", automod);//"usua" va a viajar a la pag.borrar
	        return "/Usuario/Borrar";   
	    }
	    @RequestMapping(value="/usu_borrar/{calId}",method=RequestMethod.POST) 
	    public String borrar_POST(Usuario usuario,@PathVariable Integer calId){          
	        //antes de borrar busca en el hijo Pago para lanzar error
	    	ArrayList<Integer> listado= (ArrayList<Integer>) usuService.usuID_UsuPago();
			for (Integer usuid: listado  ) {
			if (usuid==calId)
				return "redirect:/usu_errorborrar";
			}  	    	
	    	//uso el id del usuario recibido como clave del dicc
			usuService.delete(usuario.getId());        
	        return "redirect:/usuario_listar";   
	    }
		
	    @RequestMapping(value="/usu_errorborrar",method=RequestMethod.GET)
	    public String usuerrorborrar_GET(){ 
			return "/Usuario/ErrorBorrar";   
	    }    
	    
	    
	
}
