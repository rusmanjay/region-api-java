package region.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import region.api.models.Regency;

public interface RegencyRepository extends PagingAndSortingRepository<Regency, String> {

}
