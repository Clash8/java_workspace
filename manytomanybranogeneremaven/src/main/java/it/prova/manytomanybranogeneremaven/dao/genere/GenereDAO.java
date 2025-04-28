package it.prova.manytomanybranogeneremaven.dao.genere;

import it.prova.manytomanybranogeneremaven.dao.IBaseDAO;
import it.prova.manytomanybranogeneremaven.model.Genere;

import java.time.LocalDate;
import java.util.List;

public interface GenereDAO extends IBaseDAO<Genere>{
	
	public Genere findByDescrizione(String descrizioneInput) throws Exception;

	public List<Genere> listAllByBranoPubblicatoTraDueDate(LocalDate dataInizio, LocalDate dataFine) throws Exception;

	}
