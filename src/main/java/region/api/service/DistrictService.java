package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.District;

public interface DistrictService {

	Page<District> findAll(Pageable pagable);

	District findOne(String id);
	
	District create(String id, String regency_id, String name);
	
	District update(String id, String regency_id, String name);
	
	void delete(String id);
}
