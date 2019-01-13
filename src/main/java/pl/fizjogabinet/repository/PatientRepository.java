package pl.fizjogabinet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.fizjogabinet.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
