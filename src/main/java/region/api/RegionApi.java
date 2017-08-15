package region.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages= {"region.api"})
public class RegionApi implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(RegionApi.class);

	public static void main(String[] args) {
		SpringApplication.run(RegionApi.class, args);
	}

	@Autowired
    JdbcTemplate jdbcTemplate;

    public void run(String... strings) throws Exception {

        log.info("Drop tables regional");
        jdbcTemplate.execute("DROP TABLE IF EXISTS `regional`");
        
        log.info("Creating views regional");
        
        String sql  = "CREATE OR REPLACE VIEW `regional` AS ";
	        sql += "SELECT v.id AS id, ";
	        sql += "p.name AS province_name, ";
	        sql += "r.name AS regency_name, ";
	        sql += "d.name AS district_name, ";
	        sql += "v.name AS village_name ";
	        sql += "FROM `villages` v ";
	        sql += "LEFT JOIN `districts` d ON d.id = v.district_id ";
	        sql += "LEFT JOIN `regencies` r ON r.id = d.regency_id ";
	        sql += "LEFT JOIN `provinces` p ON p.id = r.province_id";
        jdbcTemplate.execute(sql);
    }
}
