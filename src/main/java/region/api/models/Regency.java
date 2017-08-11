package region.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regencies")
public class Regency {

	@Id
	private Integer id;
	
	private Integer province_id;
	
	private String name;

	public Regency() {

	}

	public Regency(Integer id, Integer provinceId, String name) {
		super();
		this.id = id;
		this.province_id = provinceId;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProvinceId() {
		return province_id;
	}

	public void setProvinceId(Integer provinceId) {
		this.province_id = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
