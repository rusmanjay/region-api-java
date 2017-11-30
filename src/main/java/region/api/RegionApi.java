package region.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages= {"region.api"})
@EnableCaching
public class RegionApi {

	public static void main(String[] args) {
		SpringApplication.run(RegionApi.class, args);
	}
}
