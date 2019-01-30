package pl.fizjogabinet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.fizjogabinet.model.entity.MedicalHistory;
@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

}
