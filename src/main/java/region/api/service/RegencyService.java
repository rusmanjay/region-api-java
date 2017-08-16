package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.Regency;

public interface RegencyService {

	Page<Regency> findAll(Pageable pagable);
	
	Regency findOne(Integer id);
	
	Regency create(Integer id, Integer provinceId, String name);

	Regency update(Integer id, Integer provinceId, String name);
	
	void delete(Integer id);
}
