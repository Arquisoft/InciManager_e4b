package asw.database.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Incidence {
	@Id
	@GeneratedValue
	private Long id;

	private String user;
	private String password;
	private String incidenceName;
	private String descripcion;
	private String localizacion;
	private List<String> tags; // Etiquetas
	private HashMap<String, String> campos; // Campos propiedad valor

	/**
	 * Consturctor el cual hace uso de la propiedad campos
	 * 
	 * @param id
	 * @param user
	 * @param password
	 * @param incidenceName
	 * @param descripcion
	 * @param localizacion
	 * @param tags
	 * 
	 */
	public Incidence(Long id, String user, String password, String incidenceName, String descripcion,
			String localizacion, List<String> tags, HashMap<String, String> campos) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.incidenceName = incidenceName;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
		this.tags = tags;
		this.campos = campos;

	}

	/**
	 * Constructor sin la propiedad campos (Constructor base)
	 * 
	 * @param id
	 * @param user
	 * @param password
	 * @param incidenceName
	 * @param descripcion
	 * @param localizacion
	 * @param tags
	 * @param comments
	 * @param expeditionDate
	 */
	public Incidence(Long id, String user, String password, String incidenceName, String descripcion,
			String localizacion, List<String> tags) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.incidenceName = incidenceName;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
		this.tags = tags;

	}

	public Incidence() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIncidenceName() {
		return incidenceName;
	}

	public void setIncidenceName(String incidenceName) {
		this.incidenceName = incidenceName;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public HashMap<String, String> getCampos() {
		return campos;
	}

	public void setCampos(HashMap<String, String> campos) {
		this.campos = campos;
	}

	public Long getId() {
		return id;
	}

}
