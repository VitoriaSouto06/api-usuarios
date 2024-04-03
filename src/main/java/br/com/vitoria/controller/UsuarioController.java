package br.com.vitoria.controller;



import java.util.ArrayList;
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
import br.com.vitoria.dto.UsuarioRecordDtoEntrada;
import br.com.vitoria.model.EnderecoModel;
import br.com.vitoria.model.UsuarioModel;
import br.com.vitoria.repositories.EnderecoRepository;
import br.com.vitoria.repositories.UsuarioRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	@PostMapping("/salvar")
	public ResponseEntity<UsuarioModel> salvarUsuario(@Valid @RequestBody UsuarioRecordDtoEntrada usuarioDto){
		var pessoaModel = new UsuarioModel();
		var enderecoModel = new EnderecoModel();
		BeanUtils.copyProperties(usuarioDto, pessoaModel);
		enderecoModel.setLogradouro(usuarioDto.endereco().getLogradouro());
		enderecoModel.setCep(usuarioDto.endereco().getCep());
		enderecoModel.setNumero(usuarioDto.endereco().getNumero());
		enderecoModel.setCidade(usuarioDto.endereco().getCidade());
		enderecoModel.setEstado(usuarioDto.endereco().getEstado());
		enderecoModel.setEnderecoPrincipal(usuarioDto.endereco().isEnderecoPrincipal());
		pessoaModel.getEndereco().add(enderecoModel);
		enderecoModel.setUsuario(pessoaModel);
		
		enderecoRepository.save(enderecoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(pessoaModel));
		
	}
	
	

	@PostMapping("/enderecoadicional/{id}")
	public ResponseEntity<UsuarioModel> salvarEnderecoAdicional(@RequestBody EnderecoRecordDto enderecoDto,@PathVariable Long id){
		var enderecoModel = new EnderecoModel();
		var usuarioModel = usuarioRepository.findById(id).get();
		BeanUtils.copyProperties(enderecoDto, enderecoModel);
		
		usuarioModel.getEndereco().add(enderecoModel);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));
		
	}
	
	@GetMapping("/listarusuarios")
	public  ResponseEntity<List<UsuarioModel>> listarUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
	}
	
	@GetMapping("listarusuario/{id}")
	public  ResponseEntity<Object> listaUmUsuario(@PathVariable Long id){
		var usuario = usuarioRepository.findById(id);
		if(usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id));
	}
	
	@PutMapping("editarusuario/{id}")
	public ResponseEntity<Object> editarUmUsuario(@RequestBody UsuarioRecordDtoEntrada usuarioDto, @PathVariable Long id){
		var usuario = usuarioRepository.findById(id);
		if(usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		}
		
		var usuarioModel = usuario.get();
		BeanUtils.copyProperties(usuarioDto, usuarioModel);
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioModel));
		
	}
}
