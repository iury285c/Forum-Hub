package hub.forum.api.topico;

import hub.forum.api.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        boolean status,
        String curso,
        Usuario usuario) {
}
