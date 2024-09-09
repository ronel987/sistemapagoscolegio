package pe.mil.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.mil.entity.Ano_Escolar;
import pe.mil.service.Ano_EscolarService;

@Controller
public class Ano_EscolarController {
	

	@Autowired
	private Ano_EscolarService ano_escolarService;

	@RequestMapping(value="/ano_escolar_listar",method=RequestMethod.GET)
	public String alquiler_listar(Map map) 
	{
		map.put("bAno_Escolar",ano_escolarService.findAll());		
		return "Año/Listar";
	}
	
	@RequestMapping(value="/ano_escolar_registrar",method=RequestMethod.GET)
	public String registrar_GET(Model model,Map map)
	{
		Ano_Escolar ano_escolarModel=new Ano_Escolar();		
		model.addAttribute("ano_escolar",ano_escolarModel);		
		return "Año/Registrar";
	}
	@RequestMapping(value="/ano_escolar_registrar",method=RequestMethod.POST)
	public String registrar_POST(Ano_Escolar ano_escolar) 
	{	
		try {
			ano_escolarService.insert(ano_escolar); 
			return "redirect:/ano_escolar_listar";
		}
		catch(Exception ex) {
			return "redirect:/ano_escolar_errorborrar";
		}
	}
	@RequestMapping(value="/ano_escolar_editar/{id}",method=RequestMethod.GET)
	public String editar_GET(Model model,Map map,@PathVariable Integer id)
	{

		Ano_Escolar ano_escolarModel=ano_escolarService.findById(id);		
		model.addAttribute("ano_escolar",ano_escolarModel);				
		return "Año/Editar";
	}
	@RequestMapping(value="/ano_escolar_editar/{id}",method=RequestMethod.POST)
	public String editar_POST(Ano_Escolar ano_escolar)
	{   
		try {
		ano_escolarService.update(ano_escolar);		
		return "redirect:/ano_escolar_listar";
		}
		catch(Exception ex) {
			return "redirect:/ano_escolar_errorborrar";
		}
	}
	
	@RequestMapping(value="/ano_escolar_borrar/{id}",method=RequestMethod.GET)
	public String borrar_GET(Model model,@PathVariable Integer id)
	{
		Ano_Escolar ano_escolarModel=ano_escolarService.findById(id);
		model.addAttribute("ano_escolar",ano_escolarModel);
		
		return "Año/Borrar";
	}
	@RequestMapping(value="/ano_escolar_borrar/{id}",method=RequestMethod.POST)
	public String borrar_POST(Ano_Escolar ano_escolar,@PathVariable Integer id)
	{
		/*ArrayList<Integer> a = (ArrayList<Integer>) ano_escolarService.findForeign();
		for (Integer idg : a ) {
			if (idg==id)
				return "redirect:/ano_escolar_errorborrar";
			}
		*/
		ano_escolarService.delete(ano_escolar.getId());		
		return "redirect:/ano_escolar_listar";
	}
	
	@RequestMapping(value="/ano_escolar_errorborrar",method=RequestMethod.GET)
    public String errorborrar_GET(){ 
		return "/Año/ErrorBorrar";   
    } 

}
