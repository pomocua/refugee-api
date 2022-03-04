package ua.pomoc.refugee.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Refugee")
@Table(name = "refugees")
public class Refugee {
    @Id
    @Column(name = "id")
    UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    @Column(name = "languages", nullable = false)
    private List<Language> languages = new ArrayList<>();

    @Column(name = "citizenship", nullable = false)
    private String citizenship;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "number_of_adults", nullable = false)
    private Integer numberOfAdults;

    @Column(name = "number_of_children", nullable = false)
    private Integer numberOfChildren;

    @Column(name = "animals", nullable = false)
    private boolean animals = false;

    @Column(name = "current_location", nullable = false)
    private String currentLocation;

    @Column(name = "destination")
    private String destination;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    @Column(name = "needs", nullable = false)
    private List<Need> needs = new ArrayList<>();

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status", nullable = false)
    private RefugeeProcedureStatus status;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;
}


//@Entity
//@Table(name = "accounts")
//class Account(
//        @Id
//        @Column(name = "id")
//        val id: UUID,
//        @Column(name = "login", nullable = false, unique = true)
//        val login: String,
//        @OneToOne(
//                mappedBy = "account",
//                cascade = [CascadeType.ALL],
//                fetch = FetchType.LAZY,
//                optional = true
//        )
//        val exchangeAccount: ExchangeAccount? = null
//) {
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//        other as Account
//
//        return Objects.equals(this.id, other.id)
//                && Objects.equals(this.login, other.login)
//                && Objects.equals(this.exchangeAccount, other.exchangeAccount)
//    }
//
//    override fun hashCode(): Int {
//        return Objects.hash(id, login, exchangeAccount)
//    }
//
//    override fun toString(): String {
//        return "Account(id=$id, login=$login)"
//    }
//}