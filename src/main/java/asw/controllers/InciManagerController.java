package asw.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asw.database.entities.Incidence;
import asw.database.location.Location;
import asw.database.status.Status;
import asw.services.IncidenceService;

@Controller
public class InciManagerController {
	
	@Autowired
	private IncidenceService inciService;
	
	
	@ResponseBody
	@RequestMapping(value = "/incidence/add",  method = RequestMethod.POST)
	private String POSTaddIncidence(@ModelAttribute Incidence inci, @ModelAttribute Location loc) {
		inci.setLocalizacion(loc);
		inci.setStatus(Status.ABIERTA);
		inciService.addIncidence(inci);
		return "Incidencia con id: " +inci.getId()+" creada";
	}

	@RequestMapping(value = "/incidence/add")
	private String GETaddIncidence(HttpSession session, Model model) {
		if(session.getAttribute("agent")==null) {
			
			return "redirect:/login";
		}
		
		model.addAttribute("inci", new Incidence());
		model.addAttribute("loc", new Location());
		return "/incidence/add";
	}
	
}
