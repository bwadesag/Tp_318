package com.example.tp318.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {
    @Id
    private String idCategory;

    @NotBlank(message = "Le nom de la catégorie est obligatoire")
    @Column(nullable = false)
    private String nomCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produit> produits;

    // Constructeurs
    public Category() {}
    public Category(String idCategory, String nomCategory) {
        this.idCategory = idCategory;
        this.nomCategory = nomCategory;
    }

    // Getters et setters
    public String getIdCategory() { return idCategory; }
    public void setIdCategory(String idCategory) { this.idCategory = idCategory; }
    public String getNomCategory() { return nomCategory; }
    public void setNomCategory(String nomCategory) { this.nomCategory = nomCategory; }
    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }
} 