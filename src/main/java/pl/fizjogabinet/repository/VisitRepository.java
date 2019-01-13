package pl.fizjogabinet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.fizjogabinet.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}
