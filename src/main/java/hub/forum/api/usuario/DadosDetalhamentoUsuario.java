package hub.forum.api.usuario;

import hub.forum.api.endereco.Endereco;

public record DadosDetalhamentoUsuario(Long id, String nome, String email, String curso, Endereco endereco) {


    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCurso(), usuario.getEndereco());
    }
}
