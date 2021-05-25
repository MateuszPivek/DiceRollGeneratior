package pl.sda.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.project.skillRollGenerator.controller.GeneratorController;
import pl.sda.project.skillRollGenerator.service.GeneratorService;


@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

    private final GeneratorController controller;

    public SpringDemoApplication(GeneratorService generatorService) {
        controller = new GeneratorController(generatorService);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.start();
    }
}
