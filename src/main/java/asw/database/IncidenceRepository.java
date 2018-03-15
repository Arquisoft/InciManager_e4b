package asw.database;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import asw.database.entities.Incidence;
import asw.database.status.Status;

public interface IncidenceRepository extends CrudRepository<Incidence, Long> {

	public Set<Incidence> findByStatus(Status s);

}
