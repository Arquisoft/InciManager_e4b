package asw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.research.ws.wadl.Method;

import asw.database.IncidenceRepository;
import asw.database.entities.Incidence;
import asw.database.location.Location;
import asw.database.status.Status;
import asw.services.IncidenceService;

@Controller
public class InciManagerController {
	@Autowired
	private IncidenceRepository incidencesRepository;

	@Autowired
	private IncidenceService inciService;
	
	@RequestMapping(value = "/incidence/add")
	private String GETaddIncidence(Model model) {
		model.addAttribute("inci", new Incidence());
		model.addAttribute("loc", new Location());
		return "/incidence/add";
	}
	@ResponseBody
	@RequestMapping(value = "/incidence/add",  method = RequestMethod.POST)
	private String POSTaddIncidence(@ModelAttribute Incidence inci, @ModelAttribute Location loc) {
		inci.setLocalizacion(loc);
		inci.setStatus(Status.ABIERTA);
		inciService.addIncidence(inci);
		return "Incidencia con id: " +inci.getId()+" creada";
	}
	
	
}
