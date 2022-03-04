package ua.pomoc.refugee.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "volunteers")
public class Volunteer {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "contact", nullable = false)
    private String contact;
}