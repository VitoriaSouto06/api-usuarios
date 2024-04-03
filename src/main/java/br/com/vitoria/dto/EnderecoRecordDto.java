package br.com.vitoria.dto;




import br.com.vitoria.model.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoRecordDto(@NotBlank @NotNull String logradouro, @NotBlank @NotNull String cep, @NotBlank @NotNull String numero, @NotBlank @NotNull String cidade, @NotBlank @NotNull String estado,UsuarioModel usuarioId) {

}
