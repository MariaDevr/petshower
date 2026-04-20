package br.com.petshower.controller;

import java.util.List;
import br.com.petshower.model.Cliente;
import br.com.petshower.dto.ClienteCreateDTO;
import br.com.petshower.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criar(@RequestBody ClienteCreateDTO dto) {
        return  clienteService.criar(dto);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody ClienteCreateDTO dto) {
        return clienteService.alterar(id,dto);
    }

    @GetMapping
    public List<Cliente> listar(){
        return  clienteService.listar();
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
