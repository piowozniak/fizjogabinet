package pl.fizjogabinet.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.fizjogabinet.model.entity.Patient;
import pl.fizjogabinet.model.entity.Therapist;
@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {
	
	@Query(value="select * from therapist where status = 'T'", nativeQuery = true)
	public List<Therapist> findByActiveTherapists();

}
