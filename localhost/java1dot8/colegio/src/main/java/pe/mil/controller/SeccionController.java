package pe.mil.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.mil.entity.Seccion;
import pe.mil.service.GradoService;
import pe.mil.service.SeccionService;

@Controller
public class SeccionController {
	
	
	@Autowired
	private SeccionService seccionService;
	
	@Autowired
	private GradoService gradoService;

	@RequestMapping(value="/seccion_listar",method=RequestMethod.GET)
	public String alquiler_listar(Map map) 
	{
		map.put("bSeccion",seccionService.findAll());		
		return "Seccion/Listar";
	}
	
	@RequestMapping(value="/seccion_registrar",method=RequestMethod.GET)
	public String registrar_GET(Model model,Map map)
	{
		Seccion seccionModel=new Seccion();		
		model.addAttribute("seccion",seccionModel);
		
		map.put("bGrado",gradoService.findAll());
		
		return "Seccion/Registrar";
	}
	@RequestMapping(value="/seccion_registrar",method=RequestMethod.POST)
	public String registrar_POST(Seccion seccion) 
	{	
		seccionService.insert(seccion); 
		return "redirect:/seccion_listar";
	}
	@RequestMapping(value="/seccion_editar/{id}",method=RequestMethod.GET)
	public String editar_GET(Model model,Map map,@PathVariable Integer id)
	{

		Seccion seccionModel=seccionService.findById(id);
		
		model.addAttribute("seccion",seccionModel);
		
		map.put("bGrado",gradoService.findAll());
		
		return "Seccion/Editar";
	}
	@RequestMapping(value="/seccion_editar/{id}",method=RequestMethod.POST)
	public String editar_POST(Seccion seccion)
	{
		seccionService.update(seccion);
		
		return "redirect:/seccion_listar";
	}
	
	@RequestMapping(value="/seccion_borrar/{id}",method=RequestMethod.GET)
	public String borrar_GET(Model model,@PathVariable Integer id)
	{
		
		Seccion seccionModel=seccionService.findById(id);
		model.addAttribute("seccion",seccionModel);
		
		return "Seccion/Borrar";
	}
	@RequestMapping(value="/seccion_borrar/{id}",method=RequestMethod.POST)
	public String borrar_POST(Seccion seccion)
	{
		seccionService.delete(seccion.getId());
		
		return "redirect:/seccion_listar";
	}
	
}


