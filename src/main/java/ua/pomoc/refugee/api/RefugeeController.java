package ua.pomoc.refugee.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pomoc.refugee.api.model.RefugeeRequest;
import ua.pomoc.refugee.api.model.RefugeeResponse;
import ua.pomoc.refugee.domain.model.Refugee;
import ua.pomoc.refugee.infrastructure.persistence.model.RefugeeEntity;
import ua.pomoc.refugee.domain.services.RefugeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/refugees")
@Slf4j
@RequiredArgsConstructor
public class RefugeeController {

    private final RefugeeService refugeeService;
    private final RefugeeResponseMapper refugeeResponseMapper;

    @GetMapping
    public List<RefugeeResponse> getAll() {
        List<Refugee> refugees = refugeeService.getAll();
        return refugees.stream()
                .map(it -> refugeeResponseMapper.map(it))
                .collect(Collectors.toList());
    }

    @PostMapping
    public RefugeeResponse save(@RequestBody RefugeeRequest request) {
        Refugee saved = refugeeService.save(request);
        return refugeeResponseMapper.map(saved);
    }
}
