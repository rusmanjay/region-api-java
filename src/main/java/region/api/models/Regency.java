package region.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="regencies")
public class Regency {

	@Id
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "province_id", referencedColumnName = "id")
	private Province province;

	@Column(nullable = false)
	private String name;
	
	@OneToMany(targetEntity = District.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "regency_id", referencedColumnName = "id")
	private List<District> district;

	public Regency() {

	}

	public Regency(Integer id, Province province, String name) {
		super();
		this.id = id;
		this.province = province;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
