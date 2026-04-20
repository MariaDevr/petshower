package br.com.petshower.controller;

import br.com.petshower.dto.AnimalCreateDTO;
import br.com.petshower.model.Animal;
import br.com.petshower.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")

public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public Animal criar(@RequestBody AnimalCreateDTO dto) {
        return animalService.criar(dto);
    }

    @PutMapping("/{id}")
    public Animal atualizar(@PathVariable Long id, @RequestBody AnimalCreateDTO dto) {
        return animalService.alterar(id, dto);
    }

    @GetMapping
    public List<Animal> listar(){
        return  animalService.listar();
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

