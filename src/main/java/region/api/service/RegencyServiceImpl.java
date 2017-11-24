package region.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import region.api.models.Province;
import region.api.models.Regency;
import region.api.repository.ProvinceRepository;
import region.api.repository.RegencyRepository;

@Service
public class RegencyServiceImpl implements RegencyService {

	@Autowired
	private ProvinceRepository provinceRepository;

	@Autowired
	private RegencyRepository regencyRepository;

	public Page<Regency> findAll(Pageable pagable) {
		return regencyRepository.findAll(pagable);
	}

	public Regency findOne(String id) {
		return regencyRepository.findOne(id);
	}

	public Regency create(String id, String provinceId, String name) {
		Province province = this.provinceRepository.findOne(provinceId);
		Regency regency = new Regency(id, province, name);
		regencyRepository.save(regency);
		return regency;
	}

	public Regency update(String id, String provinceId, String name) {
		Province province = provinceRepository.findOne(provinceId);
		Regency regency = regencyRepository.findOne(id);
		regency.setProvince(province);
		regency.setName(name);
		regencyRepository.save(regency);
		return regency;
	}

	public void delete(String id) {
		regencyRepository.delete(id);
	}
}
