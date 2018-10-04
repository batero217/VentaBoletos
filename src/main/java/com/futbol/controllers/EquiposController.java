package com.futbol.controllers;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.futbol.models.entities.Equipos;
import com.futbol.models.services.IEquiposService;

@Controller
@SessionAttributes("EQUIPOS")

public class EquiposController {
	@Autowired
	private IEquiposService equiposService;
	
	@RequestMapping(value="/equipos", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de Equipos");
		model.addAttribute("EQUIPOSS", equiposService.findAll());
		return "equipos";
	}
		
		@RequestMapping(value="/nueva")
		public String crear(Map<String, Object> model) {
			Equipos EQUIPOS = new Equipos();
			model.put("EQUIPOS", EQUIPOS);
			model.put("titulo", "Formulario de Equipos");
			return "nueva";
		}
		
		@RequestMapping(value="/nueva", method=RequestMethod.POST)
		public String guardar(@Valid Equipos EQUIPOS, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
			if(bindingResult.hasErrors()) {
				return "nueva";
			}
			equiposService.save(EQUIPOS);
			sessionStatus.setComplete();
			
			flash.addFlashAttribute("success","Equipo Añadido con exito");
			return "redirect:equipos";
		}
		
			@RequestMapping(value="/nueva/{eqID}")
			public String editar(@PathVariable(value="eqID") Long eqID, Map<String, Object> model, RedirectAttributes flash) {
				Equipos EQUIPOS = null;
				if (eqID > 0) {
					EQUIPOS = equiposService.findOne(eqID);
				}else {
					flash.addFlashAttribute("error","El expediente no puede ser cero");
					return "redirect:/equipos";
				}
				model.put("EQUIPOS", EQUIPOS);
				model.put("titulo", "Modificar Equipo");
				
				return "nueva";
			}
			
			@RequestMapping(value="/eliminarcon/{eqID}")
			public String eliminar(@PathVariable(value="eqID") Long eqID, RedirectAttributes flash) {
				if (eqID > 0 ) {
					equiposService.delete(eqID);
				}
				flash.addFlashAttribute("success","Equipo Eliminada");
				return "redirect:/equipos";
			}
			
			@RequestMapping(value="/ver/{eqID}", method=RequestMethod.GET)
			public String ver(@PathVariable(value = "eqID") Long eqID, Map<String, Object> model, RedirectAttributes flashl) {
				Equipos EQUIPOS = equiposService.findOne(eqID);
				if (EQUIPOS == null) {
					flashl.addFlashAttribute("error", "El numero de equipo no existe");
					return "redirect:/equipos";
				}

				model.put("EQUIPOS", EQUIPOS);
				model.put("titulo", "Editar Equipo");
				return "ver";
			}

}
