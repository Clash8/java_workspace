package it.prova.pizzastorespringmvc.repository.pizza;

import it.prova.pizzastorespringmvc.model.Pizza;

import java.util.List;

public interface CustomPizzaRepository {
    List<Pizza> findByExample(Pizza example);
}
