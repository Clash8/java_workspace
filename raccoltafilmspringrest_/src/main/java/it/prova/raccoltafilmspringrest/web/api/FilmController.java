package it.prova.raccoltafilmspringrest.web.api;

import java.util.List;

import it.prova.raccoltafilmspringrest.dto.RegistaDTO;
import it.prova.raccoltafilmspringrest.model.Regista;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.prova.raccoltafilmspringrest.dto.FilmDTO;
import it.prova.raccoltafilmspringrest.model.Film;
import it.prova.raccoltafilmspringrest.service.FilmService;
import it.prova.raccoltafilmspringrest.web.api.exception.FilmNotFoundException;
import it.prova.raccoltafilmspringrest.web.api.exception.IdNotNullForInsertException;

@RestController
@RequestMapping("api/film")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping
	public List<FilmDTO> getAll() {
		return FilmDTO.createFilmDTOListFromModelList(filmService.listAllElements(true), true);
	}

	@GetMapping("/{id}")
	public FilmDTO findById(@PathVariable(value = "id", required = true) long id) {
		Film film = filmService.caricaSingoloElementoEager(id);

		if (film == null)
			throw new FilmNotFoundException("Film not found con id: " + id);

		return FilmDTO.buildFilmDTOFromModel(film, true);
	}
	// gli errori di validazione vengono mostrati con 400 Bad Request ma
	// elencandoli grazie al ControllerAdvice
	@PostMapping
	public FilmDTO createNew(@Valid @RequestBody FilmDTO filmInput) {
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (filmInput.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

		Film filmInserito = filmService.inserisciNuovo(filmInput.buildFilmModel());
		return FilmDTO.buildFilmDTOFromModel(filmInserito, true);
	}

	@PutMapping("/{id}")
	public FilmDTO update(@PathVariable(value = "id", required = true) long id, @Valid @RequestBody FilmDTO filmInput) {
		Film film = filmService.caricaSingoloElemento(id);

		if (film == null)
			throw new FilmNotFoundException("Film not found con id: " + id);

		filmInput.setId(id);
		Film filmAggiornato =  filmService.aggiorna(filmInput.buildFilmModel());
		return FilmDTO.buildFilmDTOFromModel(filmAggiornato, true);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id", required = true) long id) {
		Film film = filmService.caricaSingoloElemento(id);

		if (film == null)
			throw new FilmNotFoundException("Film not found con id: " + id);

		filmService.rimuovi(id);
	}

	@PostMapping("/searchWithPagination")
	public ResponseEntity<Page<FilmDTO>> searchPaginated(
			@RequestBody FilmDTO example,
			@RequestParam(required = true) Integer pageNo,
			@RequestParam(required = true) Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {

		Page<Film> entityPageResults = filmService.findByExampleWithPagination(example.buildFilmModel(),
				pageNo, pageSize, sortBy);

		return new ResponseEntity<Page<FilmDTO>>(FilmDTO.fromModelPageToDTOPage(entityPageResults),
				HttpStatus.OK);
	}


	@PostMapping("/searchNativeWithPagination")
	public ResponseEntity<Page<FilmDTO>> searchNativePaginated(
			@RequestBody FilmDTO example,
			@RequestParam(required = true) Integer pageNo,
			@RequestParam(required = true) Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {

		Page<Film> entityPageResults = filmService.findByExampleNativeWithPagination(example.buildFilmModel(), pageNo, pageSize, sortBy);

		return new ResponseEntity<Page<FilmDTO>>(FilmDTO.fromModelPageToDTOPage(entityPageResults),
				HttpStatus.OK);
	}


	
}
