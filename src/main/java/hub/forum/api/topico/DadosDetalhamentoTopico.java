package hub.forum.api.topico;

import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoTopico(@NotNull Long id, String titulo, String mensagem, boolean status, String curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.isStatus(), topico.getCurso());
    }

}
