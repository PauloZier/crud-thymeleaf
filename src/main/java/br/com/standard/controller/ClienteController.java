package br.com.standard.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.standard.model.Cliente;
import br.com.standard.repository.ClienteRepository;
import br.com.standard.util.TextUtils;

@Controller
@RequestMapping("/")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@GetMapping
	public ModelAndView index(Model model) {

		model.addAttribute("clientes", repository.findAll());

		return new ModelAndView("index.html");
	}

	@GetMapping("/cliente")
	public ModelAndView cadastro(Model model) {

		ModelAndView modelView = new ModelAndView("cliente.html");

		modelView.addObject("cliente", new Cliente());

		return modelView;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id, Model model) {

		ModelAndView modelView = new ModelAndView("cliente.html");

		Cliente cliente = repository.findById(id).orElseGet(Cliente::new);

		cliente.setFone(TextUtils.maskPhone(cliente.getFone()));

		cliente.setCep(TextUtils.maskCep(cliente.getCep()));

		modelView.addObject("cliente", cliente);

		return modelView;
	}

	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") Long id, Model model) {

		model.addAttribute("success", "Excluído com sucesso!");

		repository.deleteById(id);

		return index(model);
	}

	@PostMapping("/cliente")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, Model model) {

		ModelAndView modelView = new ModelAndView("cliente.html");

		if (result.hasErrors()) {

			modelView.addObject("cliente", cliente);

			return modelView;
		}

		cliente.setFone(TextUtils.removeMasks(cliente.getFone()));

		cliente.setCep(TextUtils.removeMasks(cliente.getCep()));

		repository.save(cliente);

		model.addAttribute("success", "Salvo com sucesso!");

		return index(model);
	}
}
