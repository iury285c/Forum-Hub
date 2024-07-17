package hub.forum.api.usuario;

import hub.forum.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuarios(
        @NotNull
        String nome,

        @NotBlank
        @Email
        String email,

        String curso,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
