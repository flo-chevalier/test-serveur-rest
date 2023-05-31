package fr.iut.test.service;

import fr.iut.test.dao.EtudiantDAO;
import fr.iut.test.modele.Etudiant;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    private final EtudiantDAO etudiantDAO;

    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public List<Etudiant> findAll() {
        return etudiantDAO.findAll(Sort.by("nom", "prenom"));
    }

    public List<Etudiant> findAllBessac() {
        return etudiantDAO.findByNomIgnoreCase("bessac");
    }
}
