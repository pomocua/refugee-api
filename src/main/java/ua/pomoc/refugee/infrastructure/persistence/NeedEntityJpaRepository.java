package ua.pomoc.refugee.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pomoc.refugee.infrastructure.persistence.model.NeedEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NeedEntityJpaRepository extends JpaRepository<NeedEntity, UUID> {
    Optional<NeedEntity> findByCode(String code);

    List<NeedEntity> findAllByCodeIn(List<String> codes);
}
