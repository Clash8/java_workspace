package it.prova.pizzastorespringmvc.repository.pizza;

import it.prova.pizzastorespringmvc.model.Pizza;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PizzaRepository extends CrudRepository<Pizza, Long>, PagingAndSortingRepository<Pizza, Long>, JpaSpecificationExecutor<Pizza>, CustomPizzaRepository {

    List<Pizza> findByDescrizioneContainingIgnoreCaseOrIngredientiContainingIgnoreCaseOrderByDescrizioneAsc(String descrizione, String ingredienti);
}
