package region.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import region.api.models.District;
import region.api.models.Village;
import region.api.repository.DistrictRepository;
import region.api.repository.VillageRepository;

@Service
public class VillageServiceImpl implements VillageService {

	@Autowired
	VillageRepository villageRepository;

	@Autowired
	DistrictRepository districtRepository;

	public Page<Village> findAll(Pageable pagable) {
		return villageRepository.findAll(pagable);
	}

	public Village findOne(Long id) {
		return villageRepository.findOne(id);
	}

	public Village create(Long id, Integer districtId, String name) {
		District district = districtRepository.findOne(districtId);
		Village village = new Village(id, district, name);
		villageRepository.save(village);
		return village;
	}

	public Village update(Long id, Integer districtId, String name) {
		District district = districtRepository.findOne(districtId);
		Village village = villageRepository.findOne(id);
		village.setDistrict(district);
		village.setName(name);
		villageRepository.save(village);
		return village;
	}

	public void delete(Long id) {
		villageRepository.delete(id);
	}
}
