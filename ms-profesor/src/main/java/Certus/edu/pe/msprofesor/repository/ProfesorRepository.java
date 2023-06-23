package Certus.edu.pe.msprofesor.repository;

import Certus.edu.pe.msprofesor.entity.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Long> {
}
