package ua.pomoc.refugee.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(toBuilder = true, builderMethodName = "internalBuilder")
public class RefugeeResponse {
    UUID id;
    String fullName;
    LocalDate dateOfBirth;
    String gender;
    List<String> languages;
    String citizenship;
    String phoneNumber;
    int numberOfAdults;
    int numberOfChildren;
    boolean animals;
    String currentLocation;
    String destinationLocation;
    List<String> needs;
    String description;
    Instant createdAt;
    Instant updatedAt;

    public static RefugeeResponse.RefugeeResponseBuilder builder(UUID id, String fullName) {
        return internalBuilder().id(id).fullName(fullName);
    }
}
