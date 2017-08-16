package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.Province;

public interface ProvinceService {

	Page<Province> findAll(Pageable pageable);
	
	Province findOne(Integer id);
	
	Province create(Integer id, String name);
	
	Province update(Integer id, String name);
	
	void delete(Integer id);
}
