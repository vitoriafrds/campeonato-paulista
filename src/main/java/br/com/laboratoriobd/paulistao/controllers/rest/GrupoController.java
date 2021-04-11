package br.com.laboratoriobd.paulistao.controllers.rest;

import br.com.laboratoriobd.paulistao.model.dto.GrupoDTO;
import br.com.laboratoriobd.paulistao.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/grupos")
public class GrupoController {

    private GrupoService service;

    @Autowired
    public GrupoController(GrupoService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<GrupoDTO>> listar() {
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/criacao")
    public ResponseEntity<Void> gerar() {
        service.gerar();
        return ResponseEntity.ok().build();
    }
}
