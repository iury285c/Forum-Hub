package hub.forum.api.usuario;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

public record DadosListagemUsuario(Long id, String nome, String email, String curso) {

    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(),usuario.getNome(), usuario.getEmail(), usuario.getCurso());
    }

}
