package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.Regional;
import region.api.repository.RegionalRepository;

@RestController
@RequestMapping("/regional")
public class RegionalController {

	@Autowired
	RegionalRepository regionalRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Regional> findAll() {
		return regionalRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Regional find(@PathVariable Long id) {
		return regionalRepository.findOne(id);
	}
}
