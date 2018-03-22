package asw.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.database.entities.Agent;
import asw.database.entities.Incidence;
import asw.database.location.Location;
import asw.database.status.Status;
import asw.filters.FilterBySenderKind;
import asw.services.IncidenceService;

@Controller
public class InciManagerController {

	@Autowired
	private IncidenceService inciService;
	
	@Autowired
	private FilterBySenderKind filterBySenderKind;

	@RequestMapping(value = "/incidence/add")
	private String GETaddIncidence(HttpSession session, Model model) {
		if (session.getAttribute("agent") == null) {

			return "redirect:/login";
		}

		model.addAttribute("inci", new Incidence());
		model.addAttribute("loc", new Location());
		return "/incidence/add";
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	private String POSTaddIncidence(HttpSession session, Model model, @ModelAttribute Incidence inci,
			@ModelAttribute Location loc) {
		
		Agent agent = (Agent) session.getAttribute("agent");
		
		inci.setLocalizacion(loc);
		inci.setStatus(Status.ABIERTA);
		inci.setUser(agent.getEmail());
		inci.setPassword(agent.getPassword());
		if(filterBySenderKind.filtrar(inci))
			inciService.addIncidence(inci);
		else
			return "redirect:/";
		
		model.addAttribute("inciId", inci.getId());

		return "/incidence/confirm";
	}
}
