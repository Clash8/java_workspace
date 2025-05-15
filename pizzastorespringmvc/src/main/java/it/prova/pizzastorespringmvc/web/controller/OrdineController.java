package it.prova.pizzastorespringmvc.web.controller;

import it.prova.pizzastorespringmvc.dto.ClienteDTO;
import it.prova.pizzastorespringmvc.dto.OrdineDTO;
import it.prova.pizzastorespringmvc.model.Ordine;
import it.prova.pizzastorespringmvc.repository.cliente.ClienteRepository;
import it.prova.pizzastorespringmvc.service.ClienteService;
import it.prova.pizzastorespringmvc.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/ordine")
public class OrdineController {

	@Autowired
	private OrdineService ordineService;

    @Autowired
    private ClienteService clienteService;

	@GetMapping
	public ModelAndView listAllClienti() {
		ModelAndView mv = new ModelAndView();
		List<Ordine> ordini = ordineService.listAllElements();
		mv.addObject("ordini_list_attribute", OrdineDTO.createOrdineDTOListFromModelList(ordini, false));
		mv.setViewName("ordine/list");
		return mv;
	}

	@GetMapping("/insert")
	public String createOrdine(Model model) {
		model.addAttribute("insert_ordine_attr", new OrdineDTO());
		model.addAttribute("clienti_list_attribute", ClienteDTO.createClienteDTOListFromModelList(clienteService.listAllElements(), false));
		return "ordine/insert";
	}

	// inietto la request perché ci potrebbe tornare utile per ispezionare i
	// parametri
	@PostMapping("/save")
	public String saveOrdine(@Valid @ModelAttribute("insert_ordine_attr") OrdineDTO ordineDTO, BindingResult result,
			RedirectAttributes redirectAttrs, HttpServletRequest request, Model model) {

		if (ordineDTO.getCliente() == null || ordineDTO.getCliente().getId() == null) {
			model.addAttribute("clienti_list_attribute", ClienteDTO.createClienteDTOListFromModelList(clienteService.listAllElements(), false));
			result.rejectValue("cliente", "ordine.cliente.notnull");
		}
		else
			ordineDTO.setCliente(ClienteDTO.buildClienteDTOFromModel(clienteService.caricaSingoloElemento(ordineDTO.getCliente().getId()), false));

		if (result.hasErrors()) {
			return "ordine/insert";
		}
		ordineService.inserisciNuovo(ordineDTO.buildOrdineModel());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/ordine";
	}

	@GetMapping("/search")
	public String searchOrdine(Model model) {
		model.addAttribute("clienti_list_attribute", ClienteDTO.createClienteDTOListFromModelList(clienteService.listAllElements(), false));
		return "ordine/search";
	}

	@PostMapping("/list")
	public String listOrdines(OrdineDTO ordineExample, ModelMap model) {
		List<Ordine> ordines = ordineService.findByExample(ordineExample.buildOrdineModel());
		model.addAttribute("ordini_list_attribute", OrdineDTO.createOrdineDTOListFromModelList(ordines, false));
		return "ordine/list";
	}

	@GetMapping("/show/{idOrdine}")
	public String showOrdine(@PathVariable(required = true) Long idOrdine, Model model) {
		model.addAttribute("show_ordine_attr",
				OrdineDTO.buildOrdineDTOFromModel(ordineService.caricaSingoloElementoEager(idOrdine), true));
		return "ordine/show";
	}

	@GetMapping("/edit/{idOrdine}")
	public String editOrdine(@PathVariable(required = true) Long idOrdine, Model model) {
		model.addAttribute("edit_ordine_attr",
				OrdineDTO.buildOrdineDTOFromModel(ordineService.caricaSingoloElemento(idOrdine), true));
		model.addAttribute("clienti_list_attribute", ClienteDTO.createClienteDTOListFromModelList(clienteService.listAllElements(), false));
		return "ordine/edit";
	}

	@PostMapping("/update")
	public String updateOrdine(@Valid @ModelAttribute("edit_ordine_attr") OrdineDTO ordineDTO, BindingResult result,
								RedirectAttributes redirectAttrs, HttpServletRequest request, Model model) {

		if (ordineDTO.getCliente() == null || ordineDTO.getCliente().getId() == null) {
			model.addAttribute("clienti_list_attribute", ClienteDTO.createClienteDTOListFromModelList(clienteService.listAllElements(), false));
			result.rejectValue("cliente", "ordine.cliente.notnull");
		}
		else
			ordineDTO.setCliente(ClienteDTO.buildClienteDTOFromModel(clienteService.caricaSingoloElemento(ordineDTO.getCliente().getId()), false));

		if (result.hasErrors()) {
			return "ordine/edit";
		}
		ordineService.aggiorna(ordineDTO.buildOrdineModel());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/ordine";
	}

	@GetMapping("/remove/{idOrdine}")
	public String delete(@PathVariable(required = true) Long idOrdine, Model model, RedirectAttributes redirectAttrs) {
		model.addAttribute("delete_ordine_attr", ordineService.caricaSingoloElemento(idOrdine));

		if (model.getAttribute("delete_ordine_attr") == null) {
			redirectAttrs.addFlashAttribute("errorMessage", "Operazione fallita");
			return "redirect:/ordine";
		}
		ordineService.rimuovi(idOrdine);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/ordine";
	}


}
