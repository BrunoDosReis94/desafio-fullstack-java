package com.desafio.controller;

import com.desafio.service.ComentarioService;
import com.desafio.service.dto.ComentarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/ponto-turistico/{pontoTuristicoId}")
    public List<ComentarioDTO> listarPorPontoTuristico(@PathVariable Long pontoTuristicoId) {
        return comentarioService.listarPorPontoTuristico(pontoTuristicoId);
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> criar(@RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO comentarioSalvo = comentarioService.salvar(comentarioDTO);
        return ResponseEntity.ok(comentarioSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        comentarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}