package it.prova.pizzastorespringmvc.repository.regista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.pizzastorespringmvc.model.Regista;

public interface RegistaRepository
		extends PagingAndSortingRepository<Regista, Long>, JpaSpecificationExecutor<Regista>, CustomRegistaRepository {
	
	List<Regista> findByCognomeIgnoreCaseContainingOrNomeIgnoreCaseContainingOrderByNomeAsc(String cognome,
			String nome);
}
