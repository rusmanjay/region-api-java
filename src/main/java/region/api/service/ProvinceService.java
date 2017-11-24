package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.Province;

public interface ProvinceService {

	Page<Province> findAll(Pageable pageable);

	Province findOne(String id);
	
	Province create(String id, String name);
	
	Province update(String id, String name);
	
	void delete(String id);
}
