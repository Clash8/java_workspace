package it.prova.gestioneimpiegati.web.controller;

import java.util.List;

import it.prova.gestioneimpiegati.model.Satellite;
import it.prova.gestioneimpiegati.model.StatoSatellite;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.gestioneimpiegati.model.Satellite;
import it.prova.gestioneimpiegati.service.SatelliteService;


@Controller
@RequestMapping(value = "/satellite")
public class SatelliteController {

	@Autowired
	private SatelliteService satelliteService;

	@GetMapping
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView();
		List<Satellite> results = satelliteService.listAllElements();
		mv.addObject("satellite_list_attribute", results);
		mv.setViewName("satellite/list");
		return mv;
	}

	@GetMapping("/search")
	public String search() {
		return "satellite/search";
	}

	@PostMapping("/list")
	public String listByExample(Satellite example, ModelMap model) {
		List<Satellite> results = satelliteService.findByExample(example);
		model.addAttribute("satellite_list_attribute", results);
		return "satellite/list";
	}

	@GetMapping("/insert")
	public String create(Model model) {
		model.addAttribute("insert_satellite_attr", new Satellite());
		return "satellite/insert";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("insert_satellite_attr") Satellite satellite, BindingResult result,
			RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors())
			return "satellite/insert";

		String incongruenze = satellite.ottieniIncongruenze();
		if (incongruenze != null) {
			model.addAttribute("errorMessage", incongruenze);
			return "satellite/insert";
		}

		satelliteService.inserisciNuovo(satellite);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/satellite";
	}


	@GetMapping("/edit/{idSatellite}")
	public String editGet(@PathVariable(required = true) Long idSatellite, Model model) {
		model.addAttribute("edit_satellite_attr", satelliteService.caricaSingoloElemento(idSatellite));
		return "satellite/edit";
	}




	@PostMapping("/edit/edit")
	public String editPost(@Valid @ModelAttribute("edit_satellite_attr") Satellite satellite, BindingResult result,
			RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors())
			return "satellite/edit";

		String incongruenze = satellite.ottieniIncongruenze();
		if (incongruenze != null) {
			model.addAttribute("errorMessage", incongruenze);
			return "satellite/edit"; // stays on same page, so you can show the message
		}
		satelliteService.aggiorna(satellite);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/satellite";
	}

	@GetMapping("/show/{idSatellite}")
	public String show(@PathVariable(required = true) Long idSatellite, Model model) {
		model.addAttribute("show_satellite_attr", satelliteService.caricaSingoloElemento(idSatellite));
		return "satellite/show";
	}

	@GetMapping("/delete/{idSatellite}")
	public String delete(@PathVariable(required = true) Long idSatellite, Model model, RedirectAttributes redirectAttrs) {
		model.addAttribute("delete_satellite_attr", satelliteService.caricaSingoloElemento(idSatellite));

		if (model.getAttribute("delete_satellite_attr") == null) {
			redirectAttrs.addFlashAttribute("errorMessage", "Operazione fallita");
			return "redirect:/satellite";
		}
		satelliteService.rimuovi(idSatellite);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/satellite";
	}


	@GetMapping("/list_lanciati_da_piu_di_due_anni")
	public String listLanciatiDaPiuDiDueAnni(ModelMap model) {
		List<Satellite> results = satelliteService.findLanciatiDaPiuDiDueAnni();
		model.addAttribute("satellite_list_attribute", results);
		model.addAttribute("listName", "Lanciati da più di due anni (fornisce una lista di satelliti lanciati da più di due anni che non sono disattivati)");
		return "satellite/list";
	}
	@GetMapping("/list_disattivati_ma_non_rientrati")
	public String listDisattivatiMaNonRientrati(ModelMap model) {
		List<Satellite> results = satelliteService.findDisattivatiMaNonRientrati();
		model.addAttribute("satellite_list_attribute", results);
		model.addAttribute("listName", "Disattivati ma non rientrati (che sono stati disattivati ma con data rientro ancora a null)");
		return "satellite/list";
	}

	@GetMapping("/list_fissi_ora_in_orbita_10_anni")
	public String listFissiOraInOrbita10Anni(ModelMap model) {
		List<Satellite> results = satelliteService.findFissiOraInOrbita10Anni();
		model.addAttribute("satellite_list_attribute", results);
		model.addAttribute("listName", "Rimasti in orbita 10 anni ma che ora sono fissi");
		return "satellite/list";
	}

}
