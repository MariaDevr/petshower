package br.com.petshower.controller;

import br.com.petshower.dto.AtendimentoCreateDTO;
import br.com.petshower.model.Atendimento;
import br.com.petshower.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")

public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping
    public Atendimento criar(@RequestBody AtendimentoCreateDTO dto) {
        return  atendimentoService.criar(dto);
    }

    @PutMapping("/{id}")
    public Atendimento atualizar(@PathVariable Long id, @RequestBody AtendimentoCreateDTO dto) {
        return atendimentoService.alterar(id, dto);
    }

    @GetMapping
    public List<Atendimento> listar(){
        return  atendimentoService.listar();
    }

    @GetMapping("/{id}")
    public Atendimento buscarPorId(@PathVariable("id") Long id){
        return atendimentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        atendimentoService.excluir(id);
    }

}
