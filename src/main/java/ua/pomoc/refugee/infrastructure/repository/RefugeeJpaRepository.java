package ua.pomoc.refugee.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ua.pomoc.refugee.domain.model.Refugee;

import java.util.UUID;

@Repository
public interface RefugeeJpaRepository extends JpaRepository<Refugee, UUID> {

}
