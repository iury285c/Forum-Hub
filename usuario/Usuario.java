package hub.forum.api.usuario;

import hub.forum.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String curso;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Usuario(DadosCadastroUsuarios dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.curso = dados.curso();
        this.endereco = new Endereco(dados.endereco());
    }


    public void atualizarInformcoes(DadosAtualizacaoUsuarios dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
