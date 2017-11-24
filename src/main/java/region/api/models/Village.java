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
	@Column(nullable = false, length = 10)
	private String id;

	@Column(nullable = false)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "district_id", referencedColumnName = "id")
	private District district;

	public Village() {

	}

	public Village(String id, District district, String name) {
		super();
		this.id = id;
		this.district = district;
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}
