package ua.pomoc.refugee.api;

import org.springframework.stereotype.Component;
import ua.pomoc.refugee.api.model.RefugeeResponse;
import ua.pomoc.refugee.domain.model.Refugee;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RefugeeResponseMapper {

    public RefugeeResponse map(Refugee refugee) {
        List<String> languages = refugee.getLanguages().stream().map(it -> it.getValueTranslated()).collect(Collectors.toList());
        RefugeeResponse response = RefugeeResponse.builder(refugee.getId(), refugee.getFullName())
                .dateOfBirth(refugee.getDateOfBirth())
                .gender(refugee.getGender())
                .languages(languages)
                .citizenship(refugee.getCitizenship().getValue())
                .phoneNumber(refugee.getPhoneNumber())
                .numberOfAdults(refugee.getNumberOfAdults())
                .numberOfChildren(refugee.getNumberOfChildren())
                .animals(refugee.hasAnimals())
                .currentLocation(refugee.getCurrentLocation())
                .destinationLocation(refugee.getDestinationLocation())
                .needs(refugee.getNeeds().stream().map(it -> it.getValue()).collect(Collectors.toList()))
                .description(refugee.getDescription())
                .createdAt(refugee.getCreatedAt())
                .updatedAt(refugee.getUpdatedAt())
                .build();
        return response;
    }
}
