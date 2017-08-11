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

	public Integer getRegencyId() {
		return regency_id;
	}

	public void setRegencyId(Integer regencyId) {
		this.regency_id = regencyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
