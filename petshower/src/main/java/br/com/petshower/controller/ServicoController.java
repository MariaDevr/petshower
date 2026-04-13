package br.com.petshower.controller;

import br.com.petshower.model.Servico;
import br.com.petshower.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")

public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public Servico criar(@RequestBody Servico cliente) {
        return  servicoService.criar(cliente);
    }

    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable Long id, @RequestBody Servico servico) {
        return servicoService.alterar(id, servico);
    }

    @GetMapping
    public List<Servico> listar(){
        return  servicoService.listar();
    }

    @GetMapping("/{id}")
    public Servico buscarPorId(@PathVariable("id") Long id){
        return servicoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        servicoService.excluir(id);
    }

}
