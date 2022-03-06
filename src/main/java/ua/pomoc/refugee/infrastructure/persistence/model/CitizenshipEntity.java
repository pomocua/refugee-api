package ua.pomoc.refugee.infrastructure.persistence.model;

import com.neovisionaries.i18n.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citizenships")
public class CitizenshipEntity{

    @Id
    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "value", nullable = false)
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitizenshipEntity)) return false;
        CitizenshipEntity that = (CitizenshipEntity) o;
        return getCountryCode() == that.getCountryCode() && getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryCode(), getValue());
    }
}