package tr.com.project.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableScheduling
@EnableSwagger2
@SpringBootApplication
@ComponentScan("tr.com.project")
public class StartApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartApp.class);
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(StartApp.class);

        app.run(args);
        System.out.println("SERVER STARTED...");
    }


    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {

        };
    }
}

