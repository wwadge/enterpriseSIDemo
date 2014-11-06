package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("integration.xml")
@Slf4j
public class Application {

    @Autowired
    SomeService service;

    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(Application.class, args);
        context.getBean(SomeService.class).run();
    }
}
