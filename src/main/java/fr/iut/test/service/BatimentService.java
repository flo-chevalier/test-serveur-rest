package fr.iut.test.service;

import fr.iut.test.dao.BatimentDAO;
import fr.iut.test.modele.Batiment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatimentService {
    private final BatimentDAO batimentDAO;

    public BatimentService(final BatimentDAO batimentDAO) {
        this.batimentDAO = batimentDAO;
    }

    public List<Batiment> findAll() {
        return batimentDAO.findAll(Sort.by("nom"));
    }
}
