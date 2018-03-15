package asw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import asw.database.IncidenceRepository;

@Controller
public class InciManagerController {
	@Autowired
	private IncidenceRepository incidencesRepository;
	
	
}
