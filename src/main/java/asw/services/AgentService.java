package asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.database.AgentsRepository;
import asw.database.entities.Agent;

@Service
public class AgentService {

	@Autowired
	private AgentsRepository agentsRepository;
	
	public Agent getAgentByEmail(String email) {
		return agentsRepository.findByEmail(email);
	}
}
