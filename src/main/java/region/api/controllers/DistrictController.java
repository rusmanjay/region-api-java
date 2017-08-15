package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.District;
import region.api.models.Regency;
import region.api.repository.DistrictRepository;
import region.api.repository.RegencyRepository;

@RestController
@RequestMapping("/district")
public class DistrictController {

	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	RegencyRepository regencyRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<District> findAll() {
		return districtRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public District find(@PathVariable Integer id) {
		return districtRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public District create(@RequestParam Integer id, @RequestParam Integer regency_id, @RequestParam String name) {
		Regency regency = regencyRepository.findOne(regency_id);
		District district = new District(id, regency, name);
		districtRepository.save(district);
		return district;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public District update(@PathVariable Integer id, @RequestParam Integer regency_id, @RequestParam String name) {
		Regency regency = regencyRepository.findOne(regency_id);
		District district = districtRepository.findOne(id);
		district.setRegency(regency);
		district.setName(name);
		districtRepository.save(district);
		return district;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		districtRepository.delete(id);
	}
}
