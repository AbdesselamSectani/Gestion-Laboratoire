package dcc.tp2.projetservice.client;

import dcc.tp2.projetservice.module.Chercheur;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CHERCHEUR-SERVICE")
public interface ChercheurRestFeign {

    @GetMapping("/Chercheurs/{id}")
    @CircuitBreaker(name = "chercheurServiceCircuitBreaker", fallbackMethod = "fallbackGetChercheurByID")
    Chercheur GetChercheurByID(@PathVariable Long id);


    default Chercheur fallbackGetChercheurByID(Long id, Throwable throwable) {
        return new Chercheur();
    }

}
