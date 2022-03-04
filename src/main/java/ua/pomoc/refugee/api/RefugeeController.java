package ua.pomoc.refugee.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.pomoc.refugee.domain.model.Refugee;
import ua.pomoc.refugee.domain.services.RefugeeService;

@RestController
@RequestMapping("/refugees")
@Slf4j
@RequiredArgsConstructor
public class RefugeeController {

    private final RefugeeService refugeeService;

    @GetMapping
    public Flux<Refugee> getAll() {
        return refugeeService.getAll();
    }
}
