package fr.iut.test.dao;

import fr.iut.test.modele.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantDAO extends JpaRepository<Etudiant, Long> {
}
