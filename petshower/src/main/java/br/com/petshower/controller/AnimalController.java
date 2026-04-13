package br.com.petshower.controller;

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
    public Animal criar(@RequestBody Animal animal) {
       return  animalService.criar(animal);
    }

    @PutMapping("/{id}")
    public Animal atualizar(@PathVariable Long id, @RequestBody Animal animal) {
        return animalService.alterar(id, animal);
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

