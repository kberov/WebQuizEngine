package engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("control") // Where to find the controllers
@EntityScan("pojos") //Where to find the Result classes
public class WebQuizEngine {
    public static void main(String[] args) {
        SpringApplication.run(WebQuizEngine.class, args);
    }
}
