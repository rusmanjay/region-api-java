package region.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="provinces")
public class Province {

	@Id
	@Column(nullable = false, length = 2)
	private String id;

	@Column(nullable = false)
	private String name;
	
	@OneToMany(targetEntity = Regency.class)
	@JoinColumn(name = "province_id", referencedColumnName = "id")
	@JsonIgnore
	private List<Regency> regency;

	public Province() {

	}

	public Province(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Regency> getRegency() {
		return regency;
	}

	public void setRegency(List<Regency> regency) {
		this.regency = regency;
	}
}
