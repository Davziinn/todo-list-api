package br.com.menz.to_do_list_api.infraestructure.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDTO {

    private UUID sequencial;

    @NotBlank(message = "O campo [nome] é obrigatório!")
    private String nomeTag;
}
