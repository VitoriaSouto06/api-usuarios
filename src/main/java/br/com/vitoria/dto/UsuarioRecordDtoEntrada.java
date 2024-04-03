package br.com.vitoria.dto;

import java.time.LocalDate;

import br.com.vitoria.model.EnderecoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRecordDtoEntrada(@NotBlank @NotNull String nome,LocalDate dataNascimento,EnderecoModel endereco) {

}
