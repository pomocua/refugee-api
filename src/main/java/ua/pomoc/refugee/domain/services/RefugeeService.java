package ua.pomoc.refugee.domain.services;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.LanguageCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.pomoc.refugee.api.model.RefugeeRequest;
import ua.pomoc.refugee.domain.model.Refugee;
import ua.pomoc.refugee.domain.model.RefugeeProcedureStatus;
import ua.pomoc.refugee.infrastructure.persistence.RefugeeEntityJpaRepository;
import ua.pomoc.refugee.infrastructure.persistence.model.RefugeeEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefugeeService {

    private final RefugeeEntityJpaRepository refugeeEntityJpaRepository;

    public List<Refugee> getAll() {
        List<RefugeeEntity> refugeeEntities = refugeeEntityJpaRepository.findAll();
        return refugeeEntities.stream().map(it -> map(it)).collect(Collectors.toList());
    }

    public Refugee save(RefugeeRequest request) {
        RefugeeEntity entity = newRefugeeEntity(request);
        RefugeeEntity saved = refugeeEntityJpaRepository.save(entity);
        return map(saved);
    }

    private RefugeeEntity newRefugeeEntity(RefugeeRequest request) {
        List<LanguageCode> languages = request.getLanguages().stream()
                .map(it -> LanguageCode.getByCode(it, false))
                .collect(Collectors.toList());
        RefugeeEntity refugee = RefugeeEntity.builder(generateId(), request.getFullName())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .languages(languages)
                .citizenship(CountryCode.getByCode(request.getCitizenship()))
                .phoneNumber(request.getPhoneNumber())
                .numberOfAdults(request.getNumberOfAdults())
                .numberOfChildren(request.getNumberOfChildren())
                .hasAnimals(request.isHasAnimals())
                .currentLocation(request.getCurrentLocation())
                .targetLocation(request.getTargetLocation())
                .needs(request.getNeeds())
                .description(request.getDescription())
                .status(RefugeeProcedureStatus.NEW)
                .build();
        return null;
    }

    private Refugee map(RefugeeEntity entity) {
        return null;
    }

    private UUID generateId() {
        return UUID.randomUUID();
    }

}
