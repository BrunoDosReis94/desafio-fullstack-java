package com.desafio.service;

import com.desafio.domain.Comentario;
import com.desafio.domain.PontoTuristico;
import com.desafio.repository.ComentarioRepository;
import com.desafio.repository.PontoTuristicoRepository;
import com.desafio.service.dto.ComentarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PontoTuristicoRepository pontoTuristicoRepository;

    // Listar comentários por ponto turístico
    public List<Comentario> listarPorPontoTuristico(Long pontoTuristicoId) {
        return comentarioRepository.findByPontoTuristicoId(pontoTuristicoId);
    }

    // Salvar um novo comentário
    public Comentario salvar(ComentarioDTO comentarioDTO) {
        Comentario comentario = toEntity(comentarioDTO);
        comentario.setDataCriacao(new Date());
        return comentarioRepository.save(comentario);
    }

    // Excluir um comentário
    public void excluir(Long id) {
        comentarioRepository.deleteById(id);
    }

    // Converter DTO para Entidade
    private Comentario toEntity(ComentarioDTO dto) {
        Comentario comentario = new Comentario();
        comentario.setAutor(dto.getAutor());
        comentario.setTexto(dto.getTexto());

        // Busca o ponto turístico pelo ID
        Optional<PontoTuristico> pontoTuristico = pontoTuristicoRepository.findById(dto.getPontoTuristicoId());
        pontoTuristico.ifPresent(comentario::setPontoTuristico);

        return comentario;
    }
}