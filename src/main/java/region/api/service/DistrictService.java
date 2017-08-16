package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.District;

public interface DistrictService {

	Page<District> findAll(Pageable pagable);
	
	District findOne(Integer id);
	
	District create(Integer id, Integer regency_id, String name);
	
	District update(Integer id, Integer regency_id, String name);
	
	void delete(Integer id);
}
