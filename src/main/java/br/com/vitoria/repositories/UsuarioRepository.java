package br.com.vitoria.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitoria.model.UsuarioModel;



public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long>{

}
