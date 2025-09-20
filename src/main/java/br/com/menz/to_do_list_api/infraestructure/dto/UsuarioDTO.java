package br.com.menz.to_do_list_api.infraestructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    private UUID sequencial;

    @NotBlank(message = "O campo [nome] é obrigatório")
    private String nome;

    @Email(message = "Informe um email válido")
    private String email;

    @Length(min = 6, max = 8, message = "A senha deve conter de 6 a 8 caracteres")
    private String senha;
    // private List<ListaTarefaDTO> listasTarefas;
}
