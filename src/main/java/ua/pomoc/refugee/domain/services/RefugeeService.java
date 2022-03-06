package ua.pomoc.refugee.domain.services;

import com.neovisionaries.i18n.CountryCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.pomoc.refugee.api.model.RefugeeRequest;
import ua.pomoc.refugee.domain.model.Citizenship;
import ua.pomoc.refugee.domain.model.Language;
import ua.pomoc.refugee.domain.model.Need;
import ua.pomoc.refugee.domain.model.Refugee;
import ua.pomoc.refugee.domain.model.RefugeeProcedureStatus;
import ua.pomoc.refugee.infrastructure.persistence.LanguageRepository;
import ua.pomoc.refugee.infrastructure.persistence.NeedEntityJpaRepository;
import ua.pomoc.refugee.infrastructure.persistence.RefugeeEntityJpaRepository;
import ua.pomoc.refugee.infrastructure.persistence.model.CitizenshipEntity;
import ua.pomoc.refugee.infrastructure.persistence.model.NeedEntity;
import ua.pomoc.refugee.infrastructure.persistence.model.RefugeeEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefugeeService {

    private final RefugeeEntityJpaRepository refugeeEntityJpaRepository;
    private final NeedEntityJpaRepository needEntityJpaRepository;
    private final LanguageRepository languageRepository;

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
        List<String> languages = request.getLanguages().stream()
                .map(it -> languageRepository.findByCode(it).getLanguageCode())
                .collect(Collectors.toList());
        List<NeedEntity> needEntities = needEntityJpaRepository.findAllByCodeIn(request.getNeeds());
        CountryCode countryCode = CountryCode.findByName(request.getCitizenship()).stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown country"));
        CitizenshipEntity citizenship = new CitizenshipEntity(countryCode.getAlpha2(), countryCode.getName());
        RefugeeEntity refugee = RefugeeEntity.builder(generateId(), request.getFullName())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .languages(languages)
                .citizenship(citizenship)
                .phoneNumber(request.getPhoneNumber())
                .numberOfAdults(request.getNumberOfAdults())
                .numberOfChildren(request.getNumberOfChildren())
                .hasAnimals(request.isHasAnimals())
                .currentLocation(request.getCurrentLocation())
                .targetLocation(request.getTargetLocation())
                .needs(needEntities)
                .description(request.getDescription())
                .status(RefugeeProcedureStatus.NEW)
                .build();
        return refugee;
    }

    private Refugee map(RefugeeEntity entity) {
        Citizenship citizenship = new Citizenship(entity.getCitizenship().getCountryCode(), entity.getCitizenship().getValue());
        List<Language> languages = entity.getLanguages().stream().map(it -> languageRepository.findByCode(it)).collect(Collectors.toList());
        List<Need> needs = entity.getNeeds().stream().map(it -> new Need(it.getCode(), it.getValue())).collect(Collectors.toList());
        Refugee refugee = Refugee.builder(entity.getId(), entity.getFullName())
                .dateOfBirth(entity.getDateOfBirth())
                .gender(entity.getGender())
                .languages(languages)
                .citizenship(citizenship)
                .phoneNumber(entity.getPhoneNumber())
                .numberOfAdults(entity.getNumberOfAdults())
                .numberOfChildren(entity.getNumberOfChildren())
                .hasAnimals(entity.getHasAnimals())
                .currentLocation(entity.getCurrentLocation())
                .destinationLocation(entity.getTargetLocation())
                .needs(needs)
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
        return refugee;
    }

    private UUID generateId() {
        return UUID.randomUUID();
    }

}
