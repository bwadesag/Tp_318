package com.example.tp318.controller;

import com.example.tp318.model.Produit;
import com.example.tp318.model.Category;
import com.example.tp318.service.ProduitService;
import com.example.tp318.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.UUID;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    private final ProduitService produitService;
    private final CategoryService categoryService;

    public ProduitController(ProduitService produitService, CategoryService categoryService) {
        this.produitService = produitService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listProduits(Model model) {
        model.addAttribute("produits", produitService.getAllProduits());
        return "produits/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "produits/form";
    }

    @PostMapping("/save")
    public String saveProduit(@ModelAttribute @Valid Produit produit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("produit", produit);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "produits/form";
        }
        produitService.saveProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable UUID id, Model model) {
        Produit produit = produitService.getProduitById(id).orElse(new Produit());
        model.addAttribute("produit", produit);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "produits/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable UUID id) {
        produitService.deleteProduit(id);
        return "redirect:/produits";
    }
} 