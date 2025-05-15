package it.prova.pizzastorespringmvc.web.controller;

import it.prova.pizzastorespringmvc.dto.ClienteDTO;
import it.prova.pizzastorespringmvc.model.Cliente;
import it.prova.pizzastorespringmvc.service.ClienteService;
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
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ModelAndView listAllClienti() {
		ModelAndView mv = new ModelAndView();
		List<Cliente> clienti = clienteService.listAllElements();
		mv.addObject("clienti_list_attribute", ClienteDTO.createClienteDTOListFromModelList(clienti, false));
		mv.setViewName("cliente/list");
		return mv;
	}

	@GetMapping("/insert")
	public String createCliente(Model model) {
		model.addAttribute("insert_cliente_attr", new ClienteDTO());
		return "cliente/insert";
	}

	// inietto la request perché ci potrebbe tornare utile per ispezionare i
	// parametri
	@PostMapping("/save")
	public String saveCliente(@Valid @ModelAttribute("insert_cliente_attr") ClienteDTO clienteDTO, BindingResult result,
			RedirectAttributes redirectAttrs, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "cliente/insert";
		}
		clienteService.inserisciNuovo(clienteDTO.buildClienteModel());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/cliente";
	}

	@GetMapping("/search")
	public String searchCliente() {
		return "cliente/search";
	}

	@PostMapping("/list")
	public String listClientes(ClienteDTO clienteExample, ModelMap model) {
		List<Cliente> clienti = clienteService.findByExample(clienteExample.buildClienteModel());
		model.addAttribute("clienti_list_attribute", ClienteDTO.createClienteDTOListFromModelList(clienti, false));
		return "cliente/list";
	}

	@GetMapping("/show/{idCliente}")
	public String showCliente(@PathVariable(required = true) Long idCliente, Model model) {
		model.addAttribute("show_cliente_attr",
				ClienteDTO.buildClienteDTOFromModel(clienteService.caricaSingoloElementoConOrdini(idCliente), true));
		return "cliente/show";
	}

	@GetMapping("/edit/{idCliente}")
	public String editCliente(@PathVariable(required = true) Long idCliente, Model model) {
		model.addAttribute("edit_cliente_attr",
				ClienteDTO.buildClienteDTOFromModel(clienteService.caricaSingoloElemento(idCliente), false));
		return "cliente/edit";
	}

	@PostMapping("/update")
	public String updateCliente(@Valid @ModelAttribute("edit_cliente_attr") ClienteDTO clienteDTO, BindingResult result,
								RedirectAttributes redirectAttrs, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "cliente/edit";
		}
		clienteService.aggiorna(clienteDTO.buildClienteModel());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/cliente";
	}

	@GetMapping("/remove/{idCliente}")
	public String delete(@PathVariable(required = true) Long idCliente, Model model, RedirectAttributes redirectAttrs) {
		model.addAttribute("delete_cliente_attr", clienteService.caricaSingoloElemento(idCliente));

		if (model.getAttribute("delete_cliente_attr") == null) {
			redirectAttrs.addFlashAttribute("errorMessage", "Operazione fallita");
			return "redirect:/cliente";
		}
		clienteService.rimuovi(idCliente);

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/cliente";
	}


}
