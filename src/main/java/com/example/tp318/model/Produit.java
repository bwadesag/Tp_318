package com.example.tp318.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Produit {
    @Id
    @GeneratedValue
    private UUID idProduit;

    @NotBlank(message = "Le nom du produit est obligatoire")
    @Column(nullable = false)
    private String nomProduit;

    @NotNull(message = "Le prix est obligatoire")
    @PositiveOrZero(message = "Le prix doit être positif ou nul")
    @Column(nullable = false)
    private Integer prixProduit;

    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructeurs
    public Produit() {}
    public Produit(String nomProduit, Integer prixProduit, LocalDate dateExpiration, Category category) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateExpiration = dateExpiration;
        this.category = category;
    }

    // Getters et setters
    public UUID getIdProduit() { return idProduit; }
    public void setIdProduit(UUID idProduit) { this.idProduit = idProduit; }
    public String getNomProduit() { return nomProduit; }
    public void setNomProduit(String nomProduit) { this.nomProduit = nomProduit; }
    public Integer getPrixProduit() { return prixProduit; }
    public void setPrixProduit(Integer prixProduit) { this.prixProduit = prixProduit; }
    public LocalDate getDateExpiration() { return dateExpiration; }
    public void setDateExpiration(LocalDate dateExpiration) { this.dateExpiration = dateExpiration; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
} 