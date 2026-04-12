package br.com.petshower.repository;

import br.com.petshower.model.AtendimentoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AtendimentoServicoRepository extends JpaRepository<AtendimentoServico, Long> {

    List<AtendimentoServico> findByServicoId(Long servicoId);
    List<AtendimentoServico> findByAtendimentoId(Long atendimentoId);
    List<AtendimentoServico> findByPrecoDia(BigDecimal precoDia);
    List<AtendimentoServico> findByDescricao(String descricao);
}
