package region.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="villages")
public class Village {

	@Id
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "district_id", referencedColumnName = "id")
	private District district;

	@Column(nullable = false)
	private String name;

	public Village() {

	}

	public Village(Long id, District district, String name) {
		super();
		this.id = id;
		this.district = district;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
