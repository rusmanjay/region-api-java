package region.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import region.api.models.District;
import region.api.models.Regency;
import region.api.repository.DistrictRepository;
import region.api.repository.RegencyRepository;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	RegencyRepository regencyRepository;

	public Page<District> findAll(Pageable pagable) {
		return districtRepository.findAll(pagable);
	}

	public District findOne(Integer id) {
		return districtRepository.findOne(id);
	}

	public District create(Integer id, Integer regencyId, String name) {
		Regency regency = regencyRepository.findOne(regencyId);
		District district = new District(id, regency, name);
		districtRepository.save(district);
		return district;
	}

	public District update(Integer id, Integer regencyId, String name) {
		Regency regency = regencyRepository.findOne(regencyId);
		District district = districtRepository.findOne(id);
		district.setRegency(regency);
		district.setName(name);
		districtRepository.save(district);
		return district;
	}

	public void delete(Integer id) {
		districtRepository.delete(id);
	}
}
