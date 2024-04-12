package br.com.fiap.revisaocp22tdspg.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record AlunoResponse(

        Long id,

        String nome,

        String cpf,

        String email
) {
}
