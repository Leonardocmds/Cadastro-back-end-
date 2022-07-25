package br.com.angularrest.angularrest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.angularrest.angularrest.model.LoginForm;
import br.com.angularrest.angularrest.model.Usuario;
import br.com.angularrest.angularrest.model.UsuarioDto;
import br.com.angularrest.angularrest.security.AutenticacaoService;
import br.com.angularrest.angularrest.security.TokenDto;
import br.com.angularrest.angularrest.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authmanager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authmanager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			HttpHeaders headers = new HttpHeaders();
			headers.add("x-access-token", token);
			dadosLogin.getDetails();
			
			return  new ResponseEntity<TokenDto>(new TokenDto("Bearer", token),headers, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
