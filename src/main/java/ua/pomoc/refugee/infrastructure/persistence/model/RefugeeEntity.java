package ua.pomoc.refugee.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.pomoc.refugee.domain.model.RefugeeProcedureStatus;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder(toBuilder = true, builderMethodName = "internalBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Refugee")
@Table(name = "refugees")
public class RefugeeEntity extends AuditableEntity {

    @Id
    @Column(name = "id")
    UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "code", nullable = false)
    @CollectionTable(name = "refugee_languages", joinColumns = @JoinColumn(name = "refugee_id"))
    @ElementCollection
    private List<String> languages;

    @JoinColumn(name = "citizenship", referencedColumnName = "country_code", nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private CitizenshipEntity citizenship;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "number_of_adults", nullable = false)
    private Integer numberOfAdults;

    @Column(name = "number_of_children", nullable = false)
    private Integer numberOfChildren;

    @Column(name = "has_animals", nullable = false)
    private Boolean hasAnimals;

    @Column(name = "current_location", nullable = false)
    private String currentLocation;

    @Column(name = "target_location")
    private String targetLocation;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "refugee_need",
            joinColumns = @JoinColumn(name = "refugee_id"),
            inverseJoinColumns = @JoinColumn(name = "need_id")
    )
    private List<NeedEntity> needs;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RefugeeProcedureStatus status;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private VolunteerEntity volunteer;

    public static RefugeeEntityBuilder builder(UUID id, String fullName) {
        return internalBuilder().id(id).fullName(fullName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefugeeEntity)) return false;
        if (!super.equals(o)) return false;
        RefugeeEntity that = (RefugeeEntity) o;
        return getHasAnimals() == that.getHasAnimals()
                && getId().equals(that.getId())
                && getFullName().equals(that.getFullName())
                && getDateOfBirth().equals(that.getDateOfBirth())
                && getGender().equals(that.getGender())
                && getLanguages().equals(that.getLanguages())
                && getCitizenship() == that.getCitizenship()
                && getPhoneNumber().equals(that.getPhoneNumber())
                && getNumberOfAdults().equals(that.getNumberOfAdults())
                && getNumberOfChildren().equals(that.getNumberOfChildren())
                && getCurrentLocation().equals(that.getCurrentLocation())
                && getTargetLocation().equals(that.getTargetLocation())
                && getNeeds().equals(that.getNeeds())
                && Objects.equals(getDescription(), that.getDescription())
                && getStatus() == that.getStatus()
                && Objects.equals(getVolunteer(), that.getVolunteer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(), getId(), getFullName(), getDateOfBirth(),
                getGender(), getLanguages(), getCitizenship(), getPhoneNumber(),
                getNumberOfAdults(), getNumberOfChildren(), getHasAnimals(),
                getCurrentLocation(), getTargetLocation(), getNeeds(), getDescription(),
                getStatus(), getVolunteer());
    }

}