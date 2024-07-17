package hub.forum.api.controller;

import hub.forum.api.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topico")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

}