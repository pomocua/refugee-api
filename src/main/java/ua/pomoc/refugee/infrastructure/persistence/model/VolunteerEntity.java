package ua.pomoc.refugee.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.pomoc.refugee.infrastructure.persistence.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "volunteers")
public class VolunteerEntity extends BaseEntity {

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VolunteerEntity)) return false;
        if (!super.equals(o)) return false;
        VolunteerEntity that = (VolunteerEntity) o;
        return getFullname().equals(that.getFullname())
                && getContact().equals(that.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFullname(), getContact());
    }
}