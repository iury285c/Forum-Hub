package hub.forum.api.curso;

public record DadosDetalhamentoCurso(Long id, String nome, String categoria) {

    public DadosDetalhamentoCurso(Curso atualizaCurso) {
        this(atualizaCurso.getId(), atualizaCurso.getNome(), atualizaCurso.getCategoria());
    }
}
