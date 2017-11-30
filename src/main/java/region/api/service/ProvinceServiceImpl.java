package region.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import region.api.models.Province;
import region.api.repository.ProvinceRepository;

@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private ProvinceRepository provinceRepository;

	@Cacheable(
		value="provincesCache",
		key="#pageable.getPageNumber().toString().concat('-').concat(#pageable.getPageSize().toString()).concat('-').concat(#pageable.getSort().toString())",
		unless="#result==null")
	public Page<Province> findAll(Pageable pageable) {
		return provinceRepository.findAll(pageable);
	}

	@Cacheable(value="provinceCache", key="#id", unless="#result==null")
	public Province findOne(String id) {
		return provinceRepository.findOne(id);
	}

	@CacheEvict(value="provincesCache", allEntries=true)
	public Province create(String id, String name) {
		Province province = new Province(id, name);
		provinceRepository.save(province);
		return province;
	}

	@CachePut(value="provinceCache", key="#id")
	@CacheEvict(value="provincesCache", allEntries=true)
	public Province update(String id, String name) {
		Province province = provinceRepository.findOne(id);
		province.setName(name);
		provinceRepository.save(province);
		return province;
	}

	@CacheEvict(value="provinceCache", key="#id")
	public void delete(String id) {
		provinceRepository.delete(id);
	}
}
