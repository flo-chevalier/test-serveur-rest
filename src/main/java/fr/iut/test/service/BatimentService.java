package fr.iut.test.service;

import fr.iut.test.dao.BatimentDAO;
import fr.iut.test.modele.Batiment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatimentService {
    private final BatimentDAO batimentDAO;

    public BatimentService(final BatimentDAO batimentDAO) {
        this.batimentDAO = batimentDAO;
    }

    public List<Batiment> findAll() {
        return batimentDAO.findAll(Sort.by("nom"));
    }

    public Optional<Batiment> findOne(final Long id) {
        return batimentDAO.findById(id);
    }

    public Batiment ajouter(final Batiment batiment) {
        return batimentDAO.saveAndFlush(batiment);
    }

    public Batiment modifier(final Batiment batiment) {
        return batimentDAO.saveAndFlush(batiment);
    }

    public void supprimer(final Batiment batiment) {
        batimentDAO.delete(batiment);
    }
}
