package asw.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.database.entities.Agent;


@Repository
public interface AgentsRepository extends CrudRepository<Agent, Long> {
	
	public Agent findByEmail(String email);
	
	
	public Agent findByIdentificador(String identificador);
	
}
