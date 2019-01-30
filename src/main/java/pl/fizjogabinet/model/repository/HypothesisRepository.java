package pl.fizjogabinet.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.fizjogabinet.model.entity.Hypothesis;
@Repository
public interface HypothesisRepository extends JpaRepository<Hypothesis, Long> {

}
