package hub.forum.api.topico;

public record DadosAtualizacaoTopico(
        Long id,

        String titulo,

        String mensagem,

        boolean status,

        String curso) {

}
