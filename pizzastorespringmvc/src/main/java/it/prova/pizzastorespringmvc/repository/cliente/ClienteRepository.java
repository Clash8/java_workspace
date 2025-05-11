package it.prova.pizzastorespringmvc.repository.cliente;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastorespringmvc.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente>, CustomClienteRepository {

}
