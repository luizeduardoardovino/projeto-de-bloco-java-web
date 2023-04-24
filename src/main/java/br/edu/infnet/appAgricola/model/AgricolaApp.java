package br.edu.infnet.appAgricola.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories("br.edu.infnet.appAgricola.model.repository")
public class AgricolaApp {
    public static void main(String[] args) {
        SpringApplication.run(AgricolaApp.class, args);
    }
}
