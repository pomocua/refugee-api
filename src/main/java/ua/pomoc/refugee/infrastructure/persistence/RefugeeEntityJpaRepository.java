package ua.pomoc.refugee.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pomoc.refugee.infrastructure.persistence.model.RefugeeEntity;

import java.util.UUID;

@Repository
public interface RefugeeEntityJpaRepository extends JpaRepository<RefugeeEntity, UUID> {
}
