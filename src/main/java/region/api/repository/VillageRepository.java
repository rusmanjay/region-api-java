package region.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import region.api.models.Village;

public interface VillageRepository extends PagingAndSortingRepository<Village, String> {

}
