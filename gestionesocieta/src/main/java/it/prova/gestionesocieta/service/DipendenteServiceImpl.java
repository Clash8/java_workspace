package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.exception.*;
import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.ProgettoRepository;
import it.prova.gestionesocieta.repository.SocietaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.repository.DipendenteRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class DipendenteServiceImpl implements DipendenteService {

	@Autowired
	private DipendenteRepository dipendenteRepository;
    @Autowired
    private SocietaRepository societaRepository;
    @Autowired
    private ProgettoRepository progettoRepository;

	@Transactional
	public void add(Dipendente d) throws Exception {
		Societa societa = societaRepository
				.findById(d.getSocieta().getId())
				.orElseThrow(ExceptionInserimentoDipendente::new);
		if (societa.getDataFondazione().isAfter(d.getDataAssunzione()))
			throw new ExceptionDataAssunzioneSuperioreAllaDataFondazione();
		d = dipendenteRepository.save(d);
	}

	@Transactional
	public void linkDipendenteToProgetti(Long dipendenteId, List<Long> idProgetti) throws Exception{
		Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
				.orElseThrow(ExceptionDipendenteNonTrovato::new);

		List<Progetto> progetti = (List<Progetto>) progettoRepository.findAllById(idProgetti);

		if (progetti.size() != idProgetti.size())
			throw new ExceptionProgettoNonTrovato();

		for (Progetto p : progetti) {
			if (dipendente.getSocieta().getDataChiusura().minusMonths((long) p.getDurataInMesi()).isAfter(LocalDate.now()))
				p.getDipendenti().add(dipendente);
			else
				throw new ExceptionDurataProgettoTroppoLunga();
		}
		dipendente.setProgetti(progetti);

		dipendenteRepository.save(dipendente);
	}

	
	public Dipendente dipendentePiuAnzianoDelleSocietaFondatePrimaDel1990EProgettiAlmeno6Mesi() {return dipendenteRepository.findDipendentePiuAnzianoDelleSocietaFondatePrimaDel1990EProgettiAlmeno6Mesi();}


}
