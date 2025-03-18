package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import org.lessons.java.spring_la_mia_pizzeria_crud.repos.PizzaRepository;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.SpringLaMiaPizzeriaCrudApplication;
import org.lessons.java.spring_la_mia_pizzeria_crud.models.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizzas")
public class pizzaController {

    private final SpringLaMiaPizzeriaCrudApplication springLaMiaPizzeriaCrudApplication;

    @Autowired
    private PizzaRepository repo;

    pizzaController(SpringLaMiaPizzeriaCrudApplication springLaMiaPizzeriaCrudApplication) {
        this.springLaMiaPizzeriaCrudApplication = springLaMiaPizzeriaCrudApplication;
    }

    @GetMapping("")
    public String pizzasIndex(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Pizza> pizzas;
        if (search == null || search.isEmpty()) {
            pizzas = repo.findAll();
        } else {
            pizzas = repo.findByNameContainingIgnoreCase(search);
        }

        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String pizzasShow(
            @PathVariable("id") Integer id, Model model) {

        model.addAttribute("pizza", repo.findById(id).get());
        return "pizzas/show";
    }

}
