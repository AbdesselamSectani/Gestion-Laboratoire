package dcc.tp2.enseignantservice;

import dcc.tp2.enseignantservice.entities.Enseignant;
import dcc.tp2.enseignantservice.service.EnseignantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class EnseignantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnseignantServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(EnseignantService enseignantService) {
        return args -> {
            Enseignant enseignant = new Enseignant();
            enseignant.setId(null);
            enseignant.setNom("CHKHONTY");
            enseignant.setPrenom("NOUHAILA");
            enseignant.setEmail("chkhonty@gmail.com");
            enseignant.setRole("Enseignant");
            enseignant.setPassword("nouhaila");
            enseignant.setCne("LB237777");
            enseignant.setThematique("AI Research Project");
            enseignantService.Create_Enseignant(enseignant);
            System.out.println("- enseignant : " + enseignant);
        };
    }

}
