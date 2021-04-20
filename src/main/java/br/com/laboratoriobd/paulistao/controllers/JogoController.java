package br.com.laboratoriobd.paulistao.controllers;

import br.com.laboratoriobd.paulistao.model.dto.JogoDTO;
import br.com.laboratoriobd.paulistao.service.JogoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.ok().body(service.detalheJogo(dataJogo));
    }

    @GetMapping("/criacao")
    public ResponseEntity<Void> gerarJogos() {
        service.gerarJogos();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/placar")
    public ResponseEntity<Void> definirPlacar(@RequestParam int placarTimeA, @RequestParam int placarTimeB, @RequestParam String data) {
        service.definirPlacar(placarTimeA, placarTimeB, data);
        return ResponseEntity.ok().build();
    }
}
