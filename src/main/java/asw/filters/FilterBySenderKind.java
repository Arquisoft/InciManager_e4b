package asw.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.database.AgentsRepository;
import asw.database.entities.Agent;
import asw.database.entities.Incidence;

@Service
public class FilterBySenderKind implements Filter{

	@Autowired
	AgentsRepository agentRepository;
	
	@Override
	public boolean filtrar(Incidence i) {
		String emailSender = i.getUser();
		Agent sender = agentRepository.findByEmail(emailSender);
		String senderKind = sender.getKind();
		if(senderKind.equals("Person") || senderKind.equals("Entidad"))
			return true;
		if(senderKind.equals("Sensor"))
			return false;
		else
			return false;
	}

}
