package ua.pomoc.refugee.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pomoc.refugee.api.model.RefugeeRequest;
import ua.pomoc.refugee.domain.model.Refugee;
import ua.pomoc.refugee.infrastructure.persistence.model.RefugeeEntity;
import ua.pomoc.refugee.domain.services.RefugeeService;

import java.util.List;

@RestController
@RequestMapping("/refugees")
@Slf4j
@RequiredArgsConstructor
public class RefugeeController {

    private final RefugeeService refugeeService;

    @GetMapping
    public List<Refugee> getAll() {
        return refugeeService.getAll();
    }

    @PostMapping
    public Refugee save(RefugeeRequest request) {
        return refugeeService.save(request);
    }
}
