package region.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="districts")
public class District {

	@Id
	private Integer id;
	
	private Integer regency_id;
	
	private String name;

	public District() {

	}

	public District(Integer id, Integer regencyId, String name) {
		super();
		this.id = id;
		this.regency_id = regencyId;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegency_id() {
		return regency_id;
	}

	public void setRegency_id(Integer regency_id) {
		this.regency_id = regency_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
