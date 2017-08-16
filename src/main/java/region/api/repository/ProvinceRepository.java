package region.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import region.api.models.Province;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Integer> {

}
