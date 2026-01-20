package dio.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BanksAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanksAPIApplication.class, args);
	}

}
