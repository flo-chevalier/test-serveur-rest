package fr.iut.test.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BatimentForm {
    @NotBlank(message = "Le nom ne doit pas être vide")
    @Size(min = 3, max = 50, message = "La taille doit être comprise entre {min} et {max} caractères")
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
