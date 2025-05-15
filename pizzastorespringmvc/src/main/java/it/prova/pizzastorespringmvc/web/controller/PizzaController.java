package it.prova.pizzastorespringmvc.web.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import it.prova.pizzastorespringmvc.dto.ClienteDTO;
import it.prova.pizzastorespringmvc.dto.OrdineDTO;
import it.prova.pizzastorespringmvc.dto.PizzaDTO;
import it.prova.pizzastorespringmvc.model.Cliente;
import it.prova.pizzastorespringmvc.model.Pizza;
import it.prova.pizzastorespringmvc.service.ClienteService;
import it.prova.pizzastorespringmvc.service.OrdineService;
import it.prova.pizzastorespringmvc.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/pizza")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
    @Autowired
    private OrdineService ordineService;

	@GetMapping
	public ModelAndView listAllClienti() {
		ModelAndView mv = new ModelAndView();
		List<Pizza> pizze = pizzaService.listAllElements();
		mv.addObject("pizze_list_attribute", PizzaDTO.createPizzaDTOListFromModelList(pizze));
		mv.setViewName("pizza/list");
		return mv;
	}

	@GetMapping("/insert")
	public String createPizza(Model model) {
		model.addAttribute("insert_pizza_attr", new PizzaDTO());
		model.addAttribute("ordini_list_attribute", OrdineDTO.createOrdineDTOListFromModelList(ordineService.listAllElements(), false));
		return "pizza/insert";
	}

	// inietto la request perché ci potrebbe tornare utile per ispezionare i
	// parametri
	@PostMapping("/save")
	public String savePizza(@Valid @ModelAttribute("insert_pizza_attr") PizzaDTO pizzaDTO, BindingResult result,
			RedirectAttributes redirectAttrs, HttpServletRequest request) {

		// se fosse un entity questa operazione sarebbe inutile perche provvederebbe
		// da solo fare il binding dell'intero oggetto. Essendo un dto dobbiamo pensarci
		// noi 'a mano'. Se validazione risulta ok devo caricare l'oggetto per
		// visualizzarne nome e cognome nel campo testo
//		if (pizzaDTO.getRegista() == null || pizzaDTO.getRegista().getId() == null)
//			result.rejectValue("regista", "pizza.regista.notnull");
//		else
//			pizzaDTO.setRegista(RegistaDTO
//					.buildRegistaDTOFromModel(registaService.caricaSingoloElemento(pizzaDTO.getRegista().getId())));

		if (result.hasErrors()) {
			return "pizza/insert";
		}
		pizzaService.inserisciNuovo(pizzaDTO.buildPizzaModel());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/pizza";
	}

	@GetMapping("/search")
	public String searchPizza() {
		return "pizza/search";
	}

	@PostMapping("/list")
	public String listPizze(PizzaDTO pizzaExample, ModelMap model) {
		List<Pizza> pizze = pizzaService.findByExample(pizzaExample.buildPizzaModel());
		model.addAttribute("pizze_list_attribute", PizzaDTO.createPizzaDTOListFromModelList(pizze));
		return "pizza/list";
	}

	@GetMapping("/show/{idPizza}")
	public String showPizza(@PathVariable(required = true) Long idPizza, Model model) {
		model.addAttribute("show_pizza_attr",
				PizzaDTO.buildPizzaDTOFromModel(pizzaService.caricaSingoloElemento(idPizza)));
		return "pizza/show";
	}

	@GetMapping("/edit/{idPizza}")
	public String editPizza(@PathVariable(required = true) Long idPizza, Model model) {
		model.addAttribute("edit_pizza_attr",
				PizzaDTO.buildPizzaDTOFromModel(pizzaService.caricaSingoloElemento(idPizza)));
		return "pizza/edit";
	}

	@PostMapping("/update")
	public String updatePizza(@Valid @ModelAttribute("edit_pizza_attr") PizzaDTO pizzaDTO, BindingResult result,
								RedirectAttributes redirectAttrs, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "pizza/edit";
		}
		pizzaService.aggiorna(pizzaDTO.buildPizzaModel());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/pizza";
	}

	@GetMapping("/remove/{idPizza}")
	public String delete(@PathVariable(required = true) Long idPizza, Model model, RedirectAttributes redirectAttrs) {
		model.addAttribute("delete_pizza_attr", pizzaService.caricaSingoloElemento(idPizza));

		if (model.getAttribute("delete_pizza_attr") == null) {
			redirectAttrs.addFlashAttribute("errorMessage", "Operazione fallita");
			return "redirect:/pizza";
		}
		pizzaService.rimuovi(idPizza);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/pizza";
	}

	@GetMapping(value = "/searchPizzeAjax", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Pizza> searchRegista(@RequestParam String term) {
		return pizzaService.cercaByEverything(term);
	}

}
