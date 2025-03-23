package com.desafio.controller;

import com.desafio.service.PontoTuristicoService;
import com.desafio.service.dto.PontoTuristicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pontos-turisticos")
public class PontoTuristicoController {

    @Autowired
    private PontoTuristicoService pontoTuristicoService;

    @GetMapping
    public List<PontoTuristicoDTO> listarTodos() {
        return pontoTuristicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoTuristicoDTO> buscarPorId(@PathVariable Long id) {
        PontoTuristicoDTO pontoTuristico = pontoTuristicoService.buscarPorId(id);
        return ResponseEntity.ok(pontoTuristico);
    }

    @PostMapping
    public ResponseEntity<PontoTuristicoDTO> criar(@RequestBody PontoTuristicoDTO pontoTuristicoDTO) {
        PontoTuristicoDTO pontoSalvo = pontoTuristicoService.salvar(pontoTuristicoDTO);
        return ResponseEntity.ok(pontoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoTuristicoDTO> atualizar(@PathVariable Long id, @RequestBody PontoTuristicoDTO pontoTuristicoDTO) {
        PontoTuristicoDTO pontoAtualizado = pontoTuristicoService.atualizar(id, pontoTuristicoDTO);
        return ResponseEntity.ok(pontoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pontoTuristicoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}