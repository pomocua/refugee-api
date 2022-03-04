package ua.pomoc.refugee.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refugee_procedure_status")
public class RefugeeProcedureStatus {
    @Id
    @Column(name = "code", nullable = false)
    private String id;
}