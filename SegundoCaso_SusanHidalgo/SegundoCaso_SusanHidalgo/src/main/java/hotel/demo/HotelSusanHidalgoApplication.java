package hotel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HotelSusanHidalgoApplication {
        @GetMapping("/hello")
        public String hello(){
            return "hola mundo tooo";
        }
	public static void main(String[] args) {
		SpringApplication.run(HotelSusanHidalgoApplication.class, args);
                
	}

}
