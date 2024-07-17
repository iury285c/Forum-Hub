package hub.forum.api.controller;

import hub.forum.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping //método post na requisição
    @Transactional
    public void criarTopicos(@RequestBody @Valid DadosCadastroTopico dadosCriaTopico) {
        //RequestBody permite pegar o corpo do json na requisição

        topicoRepository.save(new Topico(dadosCriaTopico));
    }

    @GetMapping
    public ResponseEntity listagemTopicos(@PageableDefault(size = 10, sort = {"data"}) Pageable paginacao){
        var page = topicoRepository.findAll(Sort.by(Sort.Direction.DESC, "data"));
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var atualizatopico = topicoRepository.getReferenceById(dados.id());
        atualizatopico.atualizaTopico(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(atualizatopico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Topico> topicoExclui = topicoRepository.findById(id);
        if (topicoExclui.isPresent()){
            topicoRepository.deleteById(id);
        }

        return ResponseEntity.noContent().build();
    }
}