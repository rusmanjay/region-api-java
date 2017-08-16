package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.Province;
import region.api.service.ProvinceService;

@RestController
@RequestMapping("/v1/province")
public class ProvinceController {

	@Autowired
	private ProvinceService provinceService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Province> findAll(Pageable pageable) {
		return provinceService.findAll(pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Province find(@PathVariable Integer id) {
		return provinceService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Province create(@RequestParam Integer id, @RequestParam String name) {
		return provinceService.create(id, name);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Province update(@PathVariable Integer id, @RequestParam String name) {
		return provinceService.update(id, name);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		provinceService.delete(id);
	}
}
