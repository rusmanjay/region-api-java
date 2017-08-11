package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.Province;
import region.api.repository.ProvinceRepository;

@RestController
@RequestMapping("/province")
public class ProvinceController {
	
	@Autowired
	private ProvinceRepository provinceRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Province> findAll() {
		return provinceRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Province find(@PathVariable Integer id) {
		return provinceRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Province create(@RequestParam Integer id, @RequestParam String name) {
		Province province = new Province(id, name);
		provinceRepository.save(province);
		return province;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Province update(@PathVariable Integer id, @RequestParam String name) {
		Province province = provinceRepository.findOne(id);
		province.setName(name);
		provinceRepository.save(province);
		return province;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		provinceRepository.delete(id);
	}
}
