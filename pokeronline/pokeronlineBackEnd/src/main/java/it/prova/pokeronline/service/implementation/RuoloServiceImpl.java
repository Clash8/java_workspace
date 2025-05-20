package it.prova.pokeronline.service.implementation;

import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.repository.RuoloRepository;
import it.prova.pokeronline.service.abstraction.RuoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuoloServiceImpl implements RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    @Override
    public Ruolo cercaRuolo(String codice) {
        return ruoloRepository.findRuoloByCodice(codice);
    }
}
