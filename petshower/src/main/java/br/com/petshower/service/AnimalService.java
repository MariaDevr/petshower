package br.com.petshower.service;

import br.com.petshower.model.Animal;
import br.com.petshower.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal criar (Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> listar() {
        return animalRepository.findAll();
    }

    public Animal alterar(Long id, Animal animalAtualizado){

        Animal animal = buscarPorId(id);

        animal.setNome(animalAtualizado.getNome());
        animal.setIdade(animalAtualizado.getIdade());

        return animalRepository.save(animal);
    }

    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public void excluir(Long id) {
        animalRepository.deleteById(id);
    }

}
