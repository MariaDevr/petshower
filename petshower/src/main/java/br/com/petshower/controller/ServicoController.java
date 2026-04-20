package br.com.petshower.controller;

import br.com.petshower.dto.ServicoCreateDTO;
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
    public Servico criar(@RequestBody ServicoCreateDTO dto) {
        return  servicoService.criar(dto);
    }

    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable Long id, @RequestBody ServicoCreateDTO dto) {
        return servicoService.alterar(id, dto);
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
