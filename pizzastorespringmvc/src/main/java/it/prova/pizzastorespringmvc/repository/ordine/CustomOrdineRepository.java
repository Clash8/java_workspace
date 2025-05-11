package it.prova.pizzastorespringmvc.repository.ordine;

import it.prova.pizzastorespringmvc.model.Ordine;

import java.util.List;

public interface CustomOrdineRepository {
    List<Ordine> findByExample(Ordine example);
}
