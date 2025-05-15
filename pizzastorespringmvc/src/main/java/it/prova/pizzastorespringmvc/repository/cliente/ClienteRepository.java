package it.prova.pizzastorespringmvc.repository.cliente;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastorespringmvc.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente>, CustomClienteRepository {
    @Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.ordini WHERE c.id = :id")
    Optional<Cliente> findByIdWithOrdini(@Param("id") Long id);
}
