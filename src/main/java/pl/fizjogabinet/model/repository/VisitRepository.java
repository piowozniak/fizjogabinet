package pl.fizjogabinet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.fizjogabinet.model.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}
