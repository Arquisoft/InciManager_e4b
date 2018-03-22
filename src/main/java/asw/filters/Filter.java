package asw.filters;

import org.springframework.stereotype.Service;

import asw.database.entities.Incidence;

@Service
public interface Filter {

	public boolean filtrar(Incidence i);
}
