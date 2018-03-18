package asw.database.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import asw.database.location.Location;
import asw.database.status.Status;

@Entity
public class Incidence {
	@Id
	@GeneratedValue
	private Long id;

	private String user;
	private String password;
	private String incidenceName;
	private String descripcion;
	@Embedded
	private Location localizacion;
	@ElementCollection
	private List<String> tags; // Etiquetas
	@ElementCollection
	private Map<String, String> campos; // Campos propiedad valor

	// Campos añadidos
	private Status status;
	private String comments;
	private Date expirationDate;

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
			Location localizacion, List<String> tags, HashMap<String, String> campos) {
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
			Location localizacion, List<String> tags) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.incidenceName = incidenceName;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
		this.tags = tags;

	}

	/**
	 * Constructor completo (Construido por si acaso)
	 * 
	 * @param id
	 * @param user
	 * @param password
	 * @param incidenceName
	 * @param descripcion
	 * @param localizacion
	 * @param tags
	 * @param campos
	 * @param status
	 * @param comments
	 * @param expirationDate
	 */
	public Incidence(Long id, String user, String password, String incidenceName, String descripcion,
			Location localizacion, List<String> tags, HashMap<String, String> campos, Status status, String comments,
			Date expirationDate) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.incidenceName = incidenceName;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
		this.tags = tags;
		this.campos = campos;
		this.status = status;
		this.comments = comments;
		this.expirationDate = expirationDate;
	}

	/**
	 * Constructor vacio para JPA
	 */
	public Incidence() {
	}

	public Long getId() {
		return id;
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

	public Location getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Location localizacion) {
		this.localizacion = localizacion;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Map<String, String> getCampos() {
		return campos;
	}

	public void setCampos(HashMap<String, String> campos) {
		this.campos = campos;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidence other = (Incidence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Incidence [incidenceName=" + incidenceName + ", descripcion=" + descripcion + ", localizacion="
				+ localizacion + ", tags=" + tags + ", campos=" + campos + ", status=" + status + ", comments="
				+ comments + ", expirationDate=" + expirationDate + "]";
	}
	
	

}
