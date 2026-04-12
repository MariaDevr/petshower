package br.com.petshower.repository;

import br.com.petshower.enums.StatusAtendimento;
import br.com.petshower.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AtendimentoRepository  extends JpaRepository<Atendimento,Long> {

    List<Atendimento> findByAnimalId(Long animalId);
    List<Atendimento> findByData(Date data);
    List<Atendimento> findByEntrega(boolean entrega);
    List<Atendimento> findByStatus(StatusAtendimento statusAtendimento);
}
