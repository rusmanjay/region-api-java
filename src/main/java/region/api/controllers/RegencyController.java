package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.Regency;
import region.api.repository.RegencyRepository;

@RestController
@RequestMapping("/regency")
public class RegencyController {

	@Autowired
	RegencyRepository regencyRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Regency> findAll() {
		return regencyRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Regency find(@RequestParam Integer id) {
		return regencyRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Regency create(@RequestParam Integer id, @RequestParam Integer province_id, @RequestParam String name) {
		Regency regency = new Regency(id, province_id, name);
		regencyRepository.save(regency);
		return regency;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Regency update(@PathVariable Integer id, @RequestParam Integer province_id, @RequestParam String name) {
		Regency regency = regencyRepository.findOne(id);
		regency.setProvince_id(province_id);
		regency.setName(name);
		regencyRepository.save(regency);
		return regency;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		regencyRepository.delete(id);
	}
}
