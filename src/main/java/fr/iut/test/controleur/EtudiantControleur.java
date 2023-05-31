package fr.iut.test.controleur;

import fr.iut.test.modele.Etudiant;
import fr.iut.test.service.EtudiantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("etudiants")
public class EtudiantControleur {
    private final EtudiantService etudiantService;

    public EtudiantControleur(final EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Etudiant> getAll() {
        return etudiantService.findAll();
    }

    @GetMapping("/bessac")
    public List<Etudiant> getAllBessac() {
        return etudiantService.findAllBessac();
    }
}
