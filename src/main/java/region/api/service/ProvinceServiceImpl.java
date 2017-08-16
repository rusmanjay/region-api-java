package region.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import region.api.models.Province;
import region.api.repository.ProvinceRepository;

@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private ProvinceRepository provinceRepository;

	public Page<Province> findAll(Pageable pageable) {
		return provinceRepository.findAll(pageable);
	}

	public Province findOne(Integer id) {
		return provinceRepository.findOne(id);
	}

	public Province create(Integer id, String name) {
		Province province = new Province(id, name);
		provinceRepository.save(province);
		return province;
	}

	public Province update(Integer id, String name) {
		Province province = provinceRepository.findOne(id);
		province.setName(name);
		provinceRepository.save(province);
		return province;
	}

	public void delete(Integer id) {
		provinceRepository.delete(id);
	}
}
