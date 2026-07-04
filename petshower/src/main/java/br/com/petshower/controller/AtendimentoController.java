package br.com.petshower.controller;

import java.util.List;
import br.com.petshower.model.Atendimento;
import br.com.petshower.dto.response.AtendimentoResponseDTO;
import br.com.petshower.dto.request.AtendimentoRequestDTO;
import br.com.petshower.service.AtendimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/atendimentos")

public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping
    public Atendimento criar(@RequestBody AtendimentoRequestDTO dto) {
        return  atendimentoService.criar(dto);
    }

    @PutMapping("/{id}")
    public Atendimento atualizar(@PathVariable Long id, @RequestBody AtendimentoRequestDTO dto) {
        return atendimentoService.alterar(id, dto);
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoResponseDTO>> listar(){
        List<AtendimentoResponseDTO> atendimentoResponse =  atendimentoService.listar();
        return  ResponseEntity.ok(atendimentoResponse);
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
