package region.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import region.api.models.District;

public interface DistrictRepository extends PagingAndSortingRepository<District, Integer> {

}
