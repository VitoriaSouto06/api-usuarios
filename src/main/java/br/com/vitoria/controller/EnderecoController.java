package br.com.vitoria.controller;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitoria.dto.EnderecoRecordDto;
import br.com.vitoria.repositories.EnderecoRepository;
import br.com.vitoria.repositories.UsuarioRepository;


@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@PutMapping("editarendereco/{id}")
	public ResponseEntity<Object> editarUmEndereco(@RequestBody EnderecoRecordDto enderecoDto, @PathVariable Long id){
		var endereco = enderecoRepository.findById(id);
		if(endereco.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
		}
		
		var enderecoModel = endereco.get();
		BeanUtils.copyProperties(enderecoDto, enderecoModel);
		return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.save(enderecoModel));
		
	}
	
	@GetMapping("listaendereco/{id}")
		public ResponseEntity<Object> listaEnderecosDeUmUsuario(@PathVariable Long id) {
			var endereco = enderecoRepository.findById(id);
			if(endereco.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");

			}
			
			return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.findById(id));

		
		
		
		}
	
}
