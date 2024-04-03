package br.com.vitoria.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitoria.model.EnderecoModel;



public interface EnderecoRepository extends JpaRepository<EnderecoModel,Long>{

}
