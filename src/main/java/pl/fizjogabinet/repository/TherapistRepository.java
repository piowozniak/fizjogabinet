package pl.fizjogabinet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.fizjogabinet.entity.Therapist;
@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {

}
