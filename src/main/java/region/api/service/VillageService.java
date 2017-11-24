package region.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import region.api.models.Village;

public interface VillageService {

	Page<Village> findAll(Pageable pagable);
	
	Village findOne(String id);
	
	Village create(String id, String districtId, String name);
	
	Village update(String id, String districtId, String name);
	
	void delete(String id);
}
