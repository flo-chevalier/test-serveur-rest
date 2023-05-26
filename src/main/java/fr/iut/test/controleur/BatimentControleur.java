package fr.iut.test.controleur;

import fr.iut.test.modele.Batiment;
import fr.iut.test.service.BatimentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("batiments")
public class BatimentControleur {
    private final BatimentService batimentService;

    public BatimentControleur(final BatimentService batimentService) {
        this.batimentService = batimentService;
    }

    @GetMapping
    public List<Batiment> getAll() {
        return batimentService.findAll();
    }
}
