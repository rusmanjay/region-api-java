package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.Regency;
import region.api.service.RegencyService;

@RestController
@RequestMapping("/regency")
public class RegencyController {

	@Autowired
	RegencyService regencyService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Regency> findAll(Pageable pagable) {
		return regencyService.findAll(pagable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Regency find(@PathVariable Integer id) {
		return regencyService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Regency create(@RequestParam Integer id, @RequestParam Integer province_id, @RequestParam String name) {
		return regencyService.create(id, province_id, name);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Regency update(@PathVariable Integer id, @RequestParam Integer province_id, @RequestParam String name) {
		return regencyService.update(id, province_id, name);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		regencyService.delete(id);
	}
}
