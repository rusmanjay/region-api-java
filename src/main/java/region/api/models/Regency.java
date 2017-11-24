package region.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="regencies")
public class Regency {

	@Id
	@Column(nullable = false, length = 4)
	private String id;

	@Column(nullable = false)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "province_id", referencedColumnName = "id")
	private Province province;

	@OneToMany(targetEntity = District.class)
	@JoinColumn(name = "regency_id", referencedColumnName = "id")
	@JsonIgnore
	private List<District> district;

	public Regency() {

	}

	public Regency(String id, Province province, String name) {
		super();
		this.id = id;
		this.province = province;
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

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<District> getDistrict() {
		return district;
	}

	public void setDistrict(List<District> district) {
		this.district = district;
	}
}
