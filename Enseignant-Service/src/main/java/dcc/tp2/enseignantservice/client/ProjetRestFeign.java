package dcc.tp2.enseignantservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROJET-SERVICE")
public interface ProjetRestFeign {

    @GetMapping("/Projets/Enseignant/{id}")
    @CircuitBreaker(name = "projetServiceCircuitBreaker", fallbackMethod = "fallbackNbProjetEnseignant")
//    @Retry(name = "projetServiceRetry")
//    @RateLimiter(name = "projetServiceRate",fallbackMethod ="fallbackNbProjetEnseignant")
    Long nb_Projet_Enseignant(@PathVariable Long id);

    default Long fallbackNbProjetEnseignant(Long id, Throwable throwable) {
        return 0L;
    }

}
