package br.com.petshower.service;

import java.util.List;
import br.com.petshower.model.Cliente;
import br.com.petshower.mapper.ClienteMapper;
import br.com.petshower.repository.ClienteRepository;
import br.com.petshower.dto.request.ClienteRequestDTO;
import br.com.petshower.dto.response.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(ClienteRequestDTO dto){

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(dto.getEndereco());

        return clienteRepository.save(cliente);
    }

    public List<ClienteResponseDTO> listar(){
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toDTO)
                .toList();
    }

    public Cliente alterar(Long id, ClienteRequestDTO dto){

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

    private  Cliente aplicarAtualizacaoParcial(Cliente cliente, ClienteRequestDTO dto){

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
