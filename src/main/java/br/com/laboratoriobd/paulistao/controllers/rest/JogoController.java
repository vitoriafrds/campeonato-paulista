package br.com.laboratoriobd.paulistao.controllers.rest;

import br.com.laboratoriobd.paulistao.model.dto.JogoDTO;
import br.com.laboratoriobd.paulistao.service.JogoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/jogos")
public class JogoController {

    private JogoService service;

    @Autowired
    public JogoController(JogoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<JogoDTO> detalhe(@RequestParam String dataJogo) {
        return ResponseEntity.ok().body(service.pesquisar(dataJogo));
    }

    @GetMapping("/gerar")
    public ResponseEntity<Void> gerarJogos() {
        service.gerarJogos();
        return ResponseEntity.ok().build();
    }
}
