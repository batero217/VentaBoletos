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

import com.futbol.models.entities.Estadio;
import com.futbol.models.services.IEstadioService;

@Controller
@SessionAttributes("estadio")

public class EstadiosController {
	@Autowired
	private IEstadioService estadioService;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de estadios");
		model.addAttribute("estadio", estadioService.findAll());
		return "listar";
	}
		
		@RequestMapping(value="/form")
		public String crear(Map<String, Object> model) {
			Estadio estadio = new Estadio();
			model.put("estadio", estadio);
			model.put("titulo", "Formulario de Estadios");
			return "form";
		}
		
		@RequestMapping(value="/form", method=RequestMethod.POST)
		public String guardar(@Valid Estadio estadio, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
			if(bindingResult.hasErrors()) {
				return "form";
			}
			estadioService.save(estadio);
			sessionStatus.setComplete();
			
			flash.addFlashAttribute("success","Estadio creado con exito");
			return "redirect:listar";
		}
		
			@RequestMapping(value="/form/{estid}")
			public String editar(@PathVariable(value="estid") Long estid, Map<String, Object> model, RedirectAttributes flash) {
				Estadio estadio = null;
				if (estid > 0) {
					estadio = estadioService.findOne(estid);
				}else {
					flash.addFlashAttribute("error","El Id del estadio no puede ser cero");
					return "redirect:/listar";
				}
				model.put("estadio", estadio);
				model.put("titulo", "Editar Estadio");
				
				return "form";
			}
			
			@RequestMapping(value="/eliminar/{estid}")
			public String eliminar(@PathVariable(value="estid") Long estid, RedirectAttributes flash) {
				if (estid > 0 ) {
					estadioService.delete(estid);
				}
				flash.addFlashAttribute("success","Estadio eliminado con exito");
				return "redirect:/listar";
			}
			
			@RequestMapping(value="/ver/{estid}", method=RequestMethod.GET)
			public String ver(@PathVariable(value = "estid") Long estid, Map<String, Object> model, RedirectAttributes flashl) {
				Estadio estadio = estadioService.findOne(estid);
				if (estadio == null) {
					flashl.addFlashAttribute("error", "El estadio no existe en la base de datos");
					return "redirect:/listar";
				}

				model.put("estadio", estadio);
				model.put("titulo", "Editar Estadio");
				return "ver";
			}
			
	}

