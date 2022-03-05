package ua.pomoc.refugee.api.model;

import lombok.Value;
import ua.pomoc.refugee.domain.model.Need;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Value
public class RefugeeRequest {
    String fullName;
    LocalDate dateOfBirth;
    String gender;
    List<String> languages = new ArrayList<>();
    String citizenship;
    String phoneNumber;
    int numberOfAdults;
    int numberOfChildren;
    boolean hasAnimals;
    String currentLocation;
    String targetLocation;
    List<Need> needs = new ArrayList<>();
    String description;
}
