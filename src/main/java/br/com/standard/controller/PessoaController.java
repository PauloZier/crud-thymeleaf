package br.com.standard.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.standard.entity.Pessoa;
import br.com.standard.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/pessoa");
		mv.addObject("pessoas", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Pessoa pessoa) {
		
		ModelAndView mv = new ModelAndView("/add-pessoa");
		mv.addObject("pessoa", pessoa);
		
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {
		
		if (result.hasErrors())
			return add(pessoa);
		
		service.save(pessoa);
		
		return findAll();
	}
	
	@GetMapping("/{id}")
	public ModelAndView update(@PathVariable Long id) {
		
		return add(service.findById(id));
		
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return "redirect:/pessoa";
		
	}
}
