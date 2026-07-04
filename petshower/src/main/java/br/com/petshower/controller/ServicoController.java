package br.com.petshower.controller;

import java.util.List;
import br.com.petshower.model.Servico;
import br.com.petshower.dto.request.ServicoRequestDTO;
import br.com.petshower.dto.response.ServicoResponseDTO;
import br.com.petshower.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/servicos")

public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public Servico criar(@RequestBody ServicoRequestDTO dto) {
        return  servicoService.criar(dto);
    }

    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable Long id, @RequestBody ServicoRequestDTO dto) {
        return servicoService.alterar(id, dto);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> listar(){
        List<ServicoResponseDTO> servicoResponseDTO = servicoService.listar();
        return  ResponseEntity.ok(servicoResponseDTO);
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
