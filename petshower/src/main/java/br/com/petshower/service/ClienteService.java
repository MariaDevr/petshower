package br.com.petshower.service;

import br.com.petshower.model.Cliente;

import java.util.List;
import br.com.petshower.dto.ClienteCreateDTO;
import org.springframework.stereotype.Service;
import br.com.petshower.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(ClienteCreateDTO dto){

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(dto.getEndereco());

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente alterar(Long id, ClienteCreateDTO dto){

        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        aplicarAtualizacaoParcial(cliente, dto);

        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void excluir(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }

    private  Cliente aplicarAtualizacaoParcial(Cliente cliente, ClienteCreateDTO dto){

        if (dto.getNome() != null){
            cliente.setNome(dto.getNome());
        }

        if (dto.getEmail() != null){
            cliente.setEmail(dto.getEmail());
        }

        if (dto.getCpf() != null){
            cliente.setCpf(dto.getCpf());
        }

        if (dto.getEndereco() != null){
            cliente.setEndereco(dto.getEndereco());
        }

        return cliente;
    }
}
