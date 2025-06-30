package com.example.tp318.service;

import com.example.tp318.model.Produit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProduitService {
    List<Produit> getAllProduits();
    Optional<Produit> getProduitById(UUID id);
    Produit saveProduit(Produit produit);
    void deleteProduit(UUID id);
} 