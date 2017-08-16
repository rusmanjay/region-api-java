package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.Village;

public interface VillageService {

	Page<Village> findAll(Pageable pagable);
	
	Village findOne(Long id);
	
	Village create(Long id, Integer districtId, String name);
	
	Village update(Long id, Integer districtId, String name);
	
	void delete(Long id);
}
