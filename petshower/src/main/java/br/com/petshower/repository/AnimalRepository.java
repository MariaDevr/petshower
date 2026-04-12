package br.com.petshower.repository;

import br.com.petshower.enums.CategoriaAnimal;
import br.com.petshower.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository  extends JpaRepository<Animal, Long> {

    List<Animal> findByNome(String nome);
    List<Animal> findByIdade (int idade);
    List<Animal> findByClienteId(Long clienteId);
    List<Animal> findByCategoriaAnimal(CategoriaAnimal categoriaAnimal);
}

