package region.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import region.api.models.Village;
import region.api.repository.VillageRepository;

@RestController
@RequestMapping("/village")
public class VillageController {

	@Autowired
	VillageRepository villageRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Village> findAll() {
		return villageRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Village find(@PathVariable Long id) {
		return villageRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Village create(@RequestParam Long id, @RequestParam Integer district_id, @RequestParam String name) {
		Village village = new Village(id, district_id, name);
		villageRepository.save(village);
		return village;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Village update(@PathVariable Long id, @RequestParam Integer district_id, @RequestParam String name) {
		Village village = villageRepository.findOne(id);
		village.setDistrict_id(district_id);
		village.setName(name);
		villageRepository.save(village);
		return village;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		villageRepository.delete(id);
	}
}
