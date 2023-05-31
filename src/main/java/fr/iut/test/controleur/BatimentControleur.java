package fr.iut.test.controleur;

import fr.iut.test.form.BatimentForm;
import fr.iut.test.modele.Batiment;
import fr.iut.test.service.BatimentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public ResponseEntity<Batiment> getOne(final @PathVariable Long id) {
        return batimentService.findOne(id)
                              .map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Batiment creer(final @Valid @RequestBody BatimentForm batimentForm) {
        final Batiment batiment = new Batiment();
        batiment.setNom(batimentForm.getNom());
        return batimentService.ajouter(batiment);
    }

    @PutMapping("{id}")
    public ResponseEntity<Batiment> modifier(final @PathVariable Long id,
                                             final @Valid @RequestBody BatimentForm batimentForm) {
        return batimentService.findOne(id)
                              .map(batimentAmodifier -> {
                                  batimentAmodifier.setNom(batimentForm.getNom());
                                  return ResponseEntity.ok(batimentService.modifier(batimentAmodifier));
                              })
                              .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> supprimer(final @PathVariable Long id) {
        return batimentService.findOne(id)
                              .map(batiment -> {
                                  batimentService.supprimer(batiment);
                                  return ResponseEntity.ok().build();
                              })
                              .orElse(ResponseEntity.notFound().build());
    }
}
