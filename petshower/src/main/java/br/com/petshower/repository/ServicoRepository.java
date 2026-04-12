package br.com.petshower.repository;

import br.com.petshower.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByNome(String nome);
    List<Servico> findByPreco(BigDecimal preco);
}
