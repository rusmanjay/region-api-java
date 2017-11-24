package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.Regency;

public interface RegencyService {

	Page<Regency> findAll(Pageable pagable);

	Regency findOne(String id);
	
	Regency create(String id, String provinceId, String name);

	Regency update(String id, String provinceId, String name);
	
	void delete(String id);
}
