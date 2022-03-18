package ua.pomoc.refugee.domain.model;

import lombok.Builder;
import lombok.Value;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
@Builder(toBuilder = true, builderMethodName = "internalBuilder")
public class Refugee {
    UUID id;
    String fullName;
    LocalDate dateOfBirth;
    String gender;
    List<Language> languages;
    Citizenship citizenship;
    String phoneNumber;
    int numberOfAdults;
    int numberOfChildren;
    boolean hasAnimals;
    String currentLocation;
    String destinationLocation;
    List<Need> needs;
    String description;
    Instant createdAt;
    Instant updatedAt;

    public static Refugee.RefugeeBuilder builder(UUID id, String fullName) {
        return internalBuilder().id(id).fullName(fullName);
    }

    public boolean hasAnimals() {
        return hasAnimals;
    }
}
