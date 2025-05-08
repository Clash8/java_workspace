package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.exception.ExceptionDipendenteNonTrovato;
import it.prova.gestionesocieta.exception.ExceptionDurataProgettoTroppoLunga;
import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.exception.ExceptionProgettoNonTrovato;
import it.prova.gestionesocieta.repository.ProgettoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ProgettoServiceImpl implements ProgettoService {

	@Autowired
	private ProgettoRepository progettoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

	@Transactional
	public void add(Progetto p) {p = progettoRepository.save(p);}

	@Transactional
	public void linkProgettoToDipendenti(Long progettoId, List<Long> idDipendenti) throws Exception{

		Progetto progetto = progettoRepository.findById(progettoId)
				.orElseThrow(ExceptionProgettoNonTrovato::new);

		List<Dipendente> dipendenti = (List<Dipendente>) dipendenteRepository.findAllById(idDipendenti);

		if (dipendenti.size() != idDipendenti.size())
			throw new ExceptionDipendenteNonTrovato();

		for (Dipendente d : dipendenti) {
			if (!d.getSocieta().getDataChiusura().minusMonths((long) progetto.getDurataInMesi()).isBefore(LocalDate.now()))
				d.getProgetti().add(progetto);
			else
				throw new ExceptionDurataProgettoTroppoLunga();
		}
		progetto.getDipendenti().addAll(dipendenti);

		dipendenteRepository.saveAll(dipendenti);
	}


	public List<Progetto> listaProgettiInCuiLavoraAlmenoUnDipendenteConUnaRALAPartireDa30000() {return progettoRepository.findProgettiInCuiLavoraAlmenoUnDipendenteConUnaRALAPartireDa30000();}


	public List<Progetto> listaProgettiAnomali() {return progettoRepository.findProgettiAnomali();}

}
