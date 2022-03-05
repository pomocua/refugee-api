package ua.pomoc.refugee.domain.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.pomoc.refugee.domain.model.Refugee;
import ua.pomoc.refugee.infrastructure.repository.RefugeeJpaRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefugeeService {

    private final RefugeeJpaRepository refugeeJpaRepository;

    public List<Refugee> getAll() {
        return refugeeJpaRepository.findAll();
    }
}
