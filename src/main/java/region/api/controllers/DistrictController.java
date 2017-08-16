package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.District;
import region.api.service.DistrictService;

@RestController
@RequestMapping("/district")
public class DistrictController {

	@Autowired
	DistrictService districtService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<District> findAll(Pageable pagable) {
		return districtService.findAll(pagable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public District find(@PathVariable Integer id) {
		return districtService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public District create(@RequestParam Integer id, @RequestParam Integer regency_id, @RequestParam String name) {
		return districtService.create(id, regency_id, name);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public District update(@PathVariable Integer id, @RequestParam Integer regency_id, @RequestParam String name) {
		return districtService.update(id, regency_id, name);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		districtService.delete(id);
	}
}
