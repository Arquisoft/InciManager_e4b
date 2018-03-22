package asw.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.database.entities.Agent;
import asw.services.AgentService;
import asw.util.Assert;

@Controller
public class AgentsController {

	@Autowired
	private AgentService agentService;



	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session, Model model) {
		
		session.setAttribute("agent", null);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLogin(HttpSession session, @RequestParam String userid, @RequestParam String password,
			 Model model) {

		if (Assert.isUserIdEmpty(userid) || Assert.isPasswordEmpty(password)) {
			return "login";
		}

		Agent agent = agentService.getAgentByEmail(userid);

		if (Assert.isAgentNull(agent)) {
			System.out.println("El agente no existe");
			return "login";
		}

		if (!Assert.isPasswordCorrect(password, agent)) {
			System.out.println("Contraseña incorrecta");
			return "login";
		}

		session.setAttribute("agent", agent);

		return "incidence/add";
	}

}
