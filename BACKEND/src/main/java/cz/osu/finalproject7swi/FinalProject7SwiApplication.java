package cz.osu.finalproject7swi;

import cz.osu.finalproject7swi.service.DockerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages = {"cz.osu.finalproject7swi.model.entity"})
public class FinalProject7SwiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProject7SwiApplication.class, args);
//        DockerManager.startDockerContainer();

    }

}