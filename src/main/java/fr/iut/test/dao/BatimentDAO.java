package fr.iut.test.dao;

import fr.iut.test.modele.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatimentDAO extends JpaRepository<Batiment, Long> {
}
