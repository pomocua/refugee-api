package ua.pomoc.refugee.domain.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ua.pomoc.refugee.domain.model.Refugee;
import ua.pomoc.refugee.infrastructure.repository.RefugeeJpaRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefugeeService {

    private final RefugeeJpaRepository refugeeJpaRepository;

    public Flux<Refugee> getAll() {
        return Flux.empty();
    }
}
