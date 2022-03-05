package ua.pomoc.refugee.domain.model;

import lombok.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
public class Refugee {
    UUID id;
    String fullName;
    LocalDate dateOfBirth;
    String gender;
    List<String> languages = new ArrayList<>();
    String citizenship;
    String phoneNumber;
    int numberOfAdults;
    int numberOfChildren;
    boolean animals;
    String currentLocation;
    String destination;
    List<String> needs = new ArrayList<>();
    String description;
}