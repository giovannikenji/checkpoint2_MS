package br.com.giovanni.Checkpoint2.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.giovanni.Checkpoint2.Dto.CadastroDto;
import br.com.giovanni.Checkpoint2.Dto.LoginDto;
import br.com.giovanni.Checkpoint2.model.Cadastro;
import br.com.giovanni.Checkpoint2.model.Login;
import br.com.giovanni.Checkpoint2.repository.CadastroRepository;
import br.com.giovanni.Checkpoint2.repository.LoginRepository;

@Controller
public class CadastroController {

	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/cadastro")
	public ModelAndView criar(CadastroDto cadastro) {
		ModelAndView modelView = new ModelAndView("cadastro.html");
		return modelView;
	}
	
	@PostMapping("/cadastros")
	public ModelAndView salvar(@Valid CadastroDto cadastro, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/cadastro");
		}
		
		Cadastro cadastroEntity = modelMapper.map(cadastro, Cadastro.class);
		
		cadastroRepository.save(cadastroEntity);

		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping("/login")
	public ModelAndView criar(LoginDto login) {
		ModelAndView modelView = new ModelAndView("login.html");
		return modelView;
	}
	
	@PostMapping("/logins")
	public ModelAndView salvar(@Valid LoginDto login, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/login");
		}
		
		Login loginEntity = modelMapper.map(login, Login.class);
		
		loginRepository.save(loginEntity);

		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/home")
	public ModelAndView criar() {
		ModelAndView modelView = new ModelAndView("home.html");
		return modelView;
	}
	
	
		
}


