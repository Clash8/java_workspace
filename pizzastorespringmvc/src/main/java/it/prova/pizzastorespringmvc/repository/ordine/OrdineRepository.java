package it.prova.pizzastorespringmvc.repository.ordine;

import it.prova.pizzastorespringmvc.model.Ordine;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrdineRepository extends CrudRepository<Ordine, Long>, PagingAndSortingRepository<Ordine, Long>, JpaSpecificationExecutor<Ordine>, CustomOrdineRepository {
    @Query("from Ordine o join fetch o.cliente where o.id = ?1")
    Ordine findSingleOrdineEager(Long id);
}
