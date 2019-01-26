package pl.fizjogabinet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.fizjogabinet.entity.Attachement;

@Repository
public interface AttachementRepository extends JpaRepository<Attachement, Long> {

}
