package hub.forum.api.topico;

import hub.forum.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "curso_id")
    private String curso;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Topico(DadosCadastroTopico dadosTopico){
        this.status = true;
        this.titulo = dadosTopico.titulo();
        this.mensagem = dadosTopico.mensagem();
        this.data = dadosTopico.data();
        this.curso = dadosTopico.curso();
        this.usuario = dadosTopico.usuario();
    }

    public void atualizaTopico(DadosAtualizacaoTopico dadosAtualizaTopico) {
        if (dadosAtualizaTopico.titulo() != null){
            this.titulo = dadosAtualizaTopico.titulo();
        }
        if (dadosAtualizaTopico.mensagem() != null){
            this.mensagem = dadosAtualizaTopico.mensagem();
        }
        if (dadosAtualizaTopico.curso() != null){
            this.curso = dadosAtualizaTopico.curso();
        }
    }
}