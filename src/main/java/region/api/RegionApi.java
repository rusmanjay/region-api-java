package region.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"region.api"})
public class RegionApi {

	public static void main(String[] args) {
		SpringApplication.run(RegionApi.class, args);
	}

}
