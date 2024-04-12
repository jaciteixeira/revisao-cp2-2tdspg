package br.com.fiap.revisaocp22tdspg.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record AlunoRequest(

        @Size(min = 5, max = 255)
        @NotNull(message = "Nome é obrigatório!")
        String nome,

        //@CPF(message = "CPF inválido")
        @NotNull(message = "CPF é obrigatório!")
        String cpf,

        @Email(message = "Email inválido!")
        @NotNull(message = "Email é obrigatório!")
        String email,

        @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}")
        @NotNull(message = "Senha é obrigatório!")
        String senha
) {
}
