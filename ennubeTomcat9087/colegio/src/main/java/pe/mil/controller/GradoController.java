package pe.mil.controller;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pe.mil.entity.Grado;
import pe.mil.service.Ano_EscolarService;
import pe.mil.service.GradoService;

@Controller
public class GradoController {
	
	@Autowired
	private GradoService gradoService;
	
	@Autowired
	private Ano_EscolarService ano_escolarService;
	
	@RequestMapping(value="/grado_listar",method=RequestMethod.GET)
	public String alquiler_listar(Map map) 
	{
		map.put("bGrado",gradoService.findAll());		
		return "Grado/Listar";
	}
	
	@RequestMapping(value="/grado_registrar",method=RequestMethod.GET)
	public String registrar_GET(Model model,Map map)
	{
		Grado gradoModel=new Grado();		
		model.addAttribute("grado",gradoModel);		
		map.put("bAno_Escolar",ano_escolarService.findAll());		
		return "Grado/Registrar";
	}
	@RequestMapping(value="/grado_registrar",method=RequestMethod.POST)
	public String registrar_POST(Grado grado) 
	{	
		gradoService.insert(grado); 
		return "redirect:/grado_listar";
	}
	@RequestMapping(value="/grado_editar/{id}",method=RequestMethod.GET)
	public String editar_GET(Model model,Map map,@PathVariable Integer id)
	{

		Grado gradoModel=gradoService.findById(id);
		
		model.addAttribute("grado",gradoModel);
		
		map.put("bAno_Escolar",ano_escolarService.findAll());
		
		return "Grado/Editar";
	}
	@RequestMapping(value="/grado_editar/{id}",method=RequestMethod.POST)
	public String editar_POST(Grado grado)
	{
		gradoService.update(grado);
		
		return "redirect:/grado_listar";
	}
	
	@RequestMapping(value="/grado_borrar/{id}",method=RequestMethod.GET)
	public String borrar_GET(Model model,@PathVariable Integer id)
	{
		
		Grado gradoModel=gradoService.findById(id);
		model.addAttribute("grado",gradoModel);
		
		return "Grado/Borrar";
	}
	@RequestMapping(value="/grado_borrar/{id}",method=RequestMethod.POST)
	public String borrar_POST(Grado grado,@PathVariable Integer id)
	{
		/*ArrayList<Integer> a = (ArrayList<Integer>) gradoService.findForeign();
		for (Integer idg : a ) {
			if (idg==id)
				
			}
		*/
		try {
			gradoService.delete(grado.getId());			
			return "redirect:/grado_listar";
		}
		catch(Exception ex) {
			return "redirect:/grado_errorborrar";
		}
		
	}
	
	
	
	
	
}
