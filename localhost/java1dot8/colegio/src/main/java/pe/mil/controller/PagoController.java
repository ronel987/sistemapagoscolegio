package pe.mil.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.mil.entity.Pago;
import pe.mil.service.CalendarioService;
import pe.mil.service.MatriculaService;
import pe.mil.service.PagoService;
import pe.mil.service.UsuarioService;


@Controller
public class PagoController {
	@Autowired       
    private PagoService paService; //servira para cualkier hijo q defina en la configuracion
	@Autowired       
    private CalendarioService calendaService; 
	@Autowired       
    private UsuarioService usuarioService;
	@Autowired       
    private MatriculaService matriService;
	
	@RequestMapping(value="/pago_listar",method=RequestMethod.GET)
    public String listar_GET(Map map){        //Map permite enviar variables a una pagina web   
		List<Pago> listapagos=(List<Pago>) paService.findAll();
        map.put("baraja",listapagos);  
        return "/Pago/Listar";   
    }
	
	@RequestMapping(value="/pago_cp/{id}",method=RequestMethod.GET) //llamado desde listar:pa ver CP
    public String detalle_GET(Model model,@PathVariable Integer id){        
        Pago productomod= paService.findById(id); // esta cargado 
        model.addAttribute("pago", productomod);  //envia obj
        model.addAttribute("aidi", id);
        return "/Pago/CP";   
    }
	
	@RequestMapping(value="/pago_registrar",method=RequestMethod.GET)
    public String registrar_GET(Model model,Map map){        
		Pago Model=new Pago(); //vacio sus propiedades=null
        model.addAttribute("pago",Model);       
        map.put("bCalenda",calendaService.findAll());  //se envia la lista de calenda al combobox
        map.put("bUsuario",usuarioService.findAll());    //se envia lista de usuarios al combobox
        map.put("bMatricula",matriService.findAll());
        return "/Pago/Registrar";   
    }    
	//Hibernate espera q la instancia matricula,usuario y calendario sean persistentes
	@RequestMapping(value="/pago_registrar",method=RequestMethod.POST)
    public String registrar_POST(Pago pago){        //debo hacer matri antes q esto funke 
		paService.insert(pago);
        return "redirect:/pago_listar";   
    }    
	
	//la url se recibe mas corta:
		@RequestMapping(value="/pago_editar/{calId}",method=RequestMethod.GET) //llamado desde listar:recibe el id escogido
	    public String editar_GET(Model model,@PathVariable Integer calId,Map map){        
			Pago calmod= paService.findById(calId); // esta cargado 
	        model.addAttribute("pago", calmod);    //envio auto completo
	        map.put("bCalenda",calendaService.findAll());  //se envia la lista de calenda al combobox
	        map.put("bUsuario",usuarioService.findAll());    //se envia lista de usuarios al combobox
	        map.put("bMatricula",matriService.findAll());  	        
	        return "/Pago/Editar";   
	    }
	
		@RequestMapping(value="/pago_editar/{calId}",method=RequestMethod.POST) 
	    public String editar_POST(Pago pago){  						
			paService.update(pago);
	        return "redirect:/pago_listar";   
	    }
		
		@RequestMapping(value="/pago_borrar/{calId}",method=RequestMethod.GET) //llamado desde listar:recibe el id del auto escogido
	    public String borrar_GET(Model model,@PathVariable Integer calId){        
			Pago automod=paService.findById(calId); //automod esta cargado con el pro completo
	        model.addAttribute("pago", automod);//"usua" va a viajar a la pag.borrar
	        return "/Pago/Borrar";   
	    }
	    @RequestMapping(value="/pago_borrar/{calId}",method=RequestMethod.POST) 
	    public String borrar_POST(Pago pago,@PathVariable Integer calId){          
	        	//uso el id del usuario recibido como clave del dicc
			paService.delete(pago.getId());        
	        return "redirect:/pago_listar";   
	    }
		
	    	    
	
}
