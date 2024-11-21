package dcc.tp2.enseignantservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CHERCHEUR-SERVICE")
public interface ChercheurRestFeign {

    @GetMapping("/Chercheurs/Enseignant/{id}")
    @CircuitBreaker(name = "chercheurServiceCircuitBreaker", fallbackMethod = "fallbackNbChercheurEnseignant")
    //@Retry(name = "chercheurServiceRetry")
    Long nb_chercheur_Enseignant(@PathVariable Long id);

    default Long fallbackNbChercheurEnseignant(Long id, Throwable throwable) {

        return 0L;
    }
}
