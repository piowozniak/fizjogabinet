package pl.fizjogabinet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.fizjogabinet.entity.MedicalHistory;
@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

}
