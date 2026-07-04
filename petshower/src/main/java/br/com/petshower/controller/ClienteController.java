package br.com.petshower.controller;

import java.util.List;
import br.com.petshower.model.Cliente;
import br.com.petshower.service.ClienteService;
import br.com.petshower.dto.request.ClienteRequestDTO;
import br.com.petshower.dto.response.ClienteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criar(@RequestBody ClienteRequestDTO dto) {
        return  clienteService.criar(dto);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
        return clienteService.alterar(id,dto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar(){
        List<ClienteResponseDTO> clienteResponseDTO = clienteService.listar();
        return ResponseEntity.ok(clienteResponseDTO);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable("id") Long id){
        return clienteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.excluir(id);
    }
}
