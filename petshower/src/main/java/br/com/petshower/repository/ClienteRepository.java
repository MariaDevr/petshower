package br.com.petshower.repository;

import br.com.petshower.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByEmail(String email);
    List<Cliente> findByCpf(String cpf);
    List<Cliente> findByEndereco(String endereco);
}
