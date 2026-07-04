package br.com.petshower.controller;

import java.util.List;

import br.com.petshower.dto.response.AnimalResponseDTO;
import br.com.petshower.model.Animal;
import br.com.petshower.dto.request.AnimalRequestDTO;
import br.com.petshower.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/animais")

public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public Animal criar(@RequestBody AnimalRequestDTO dto) {
        return animalService.criar(dto);
    }

    @PutMapping("/{id}")
    public Animal atualizar(@PathVariable Long id, @RequestBody AnimalRequestDTO dto) {
        return animalService.alterar(id, dto);
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> listar(){
        List<AnimalResponseDTO> animalResponse = animalService.listar();
        return  ResponseEntity.ok(animalResponse);
    }

    @GetMapping("/{id}")
    public Animal buscarPorId(@PathVariable("id") Long id){
        return animalService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        animalService.excluir(id);
    }

}

