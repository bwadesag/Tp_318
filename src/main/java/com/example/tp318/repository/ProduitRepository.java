package com.example.tp318.repository;

import com.example.tp318.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {
} 