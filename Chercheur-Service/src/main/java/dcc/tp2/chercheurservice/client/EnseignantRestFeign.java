package dcc.tp2.chercheurservice.client;


import dcc.tp2.chercheurservice.module.Enseignant;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENSEIGNANT-SERVICE")
public interface EnseignantRestFeign {

    @GetMapping("/Enseignants/{id}")
    @CircuitBreaker(name = "enseignantServiceCircuitBreaker", fallbackMethod = "fallbackEnseignantByID")
//    @Retry(name = "enseignantServiceRetry")
//    @RateLimiter(name = "enseignantServiceRate",fallbackMethod ="fallbackEnseignantByID")
    Enseignant Enseignant_ByID(@PathVariable Long id);

    default Enseignant fallbackEnseignantByID(Long id, Throwable throwable) {

        return new Enseignant();
    }
}
