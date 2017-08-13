package region.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "Regional")
public class Regional implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "province_name")
	private String province_name;

	@Column(name = "regency_name")
	private String regency_name;

	@Column(name = "district_name")
	private String district_name;

	@Column(name = "village_name")
	private String village_name;

	public Long getId() {
		return id;
	}

	public String getProvince_name() {
		return province_name;
	}

	public String getRegency_name() {
		return regency_name;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public String getVillage_name() {
		return village_name;
	}
}
