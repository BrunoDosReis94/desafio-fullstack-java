package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.Pais;
import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.repository.PaisRepository;
import br.com.juridico.totvs.fullstack.Backend.repository.PontoTuristicoRepository;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PontoTuristicoService {

    @Autowired
    private PontoTuristicoRepository pontoTuristicoRepository;

    @Autowired
    private PaisRepository paisRepository;

    // Métodos para salvar, buscar, atualizar e excluir pontos turísticos
    public PontoTuristico salvar(PontoTuristicoDTO pontoTuristicoDTO) {
        PontoTuristico pontoTuristico = toEntity(pontoTuristicoDTO);
        return pontoTuristicoRepository.save(pontoTuristico);
    }

    // Método para converter DTO em Entidade
    private PontoTuristico toEntity(PontoTuristicoDTO dto) {
        PontoTuristico pontoTuristico = new PontoTuristico();
        pontoTuristico.setNome(dto.getNome());
        pontoTuristico.setCidade(dto.getCidade());
        pontoTuristico.setMelhorEstacao(dto.getMelhorEstacao());
        pontoTuristico.setResumo(dto.getResumo());

        // Busca o país pelo ID
        Optional<Pais> pais = paisRepository.findById(dto.getPaisId());
        pais.ifPresent(pontoTuristico::setPais);

        return pontoTuristico;
    }
}