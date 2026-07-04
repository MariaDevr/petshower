package br.com.petshower.service;

import java.util.List;
import br.com.petshower.model.Animal;
import br.com.petshower.model.Cliente;
import br.com.petshower.mapper.AnimalMapper;
import br.com.petshower.repository.AnimalRepository;
import br.com.petshower.dto.request.AnimalRequestDTO;
import br.com.petshower.repository.ClienteRepository;
import br.com.petshower.dto.response.AnimalResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Animal criar(AnimalRequestDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Animal animal = new Animal();
        animal.setCliente(cliente);
        animal.setNome(dto.getNome());
        animal.setIdade(dto.getIdade());
        animal.setCategoriaAnimal(dto.getCategoriaAnimal());

        return animalRepository.save(animal);
    }

    public List<AnimalResponseDTO> listar() {
        return animalRepository.findAll()
                .stream()
                .map(AnimalMapper::toDTO)
                .toList();
    }

    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public Animal alterar(Long id, AnimalRequestDTO dto) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        aplicarAtualizacaoParcial(animal, dto);

        return animalRepository.save(animal);
    }

    public void excluir(Long id) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        animalRepository.delete(animal);
    }

    private Animal aplicarAtualizacaoParcial(Animal animal, AnimalRequestDTO dto) {

        if (dto.getClienteId() != null) {

            Cliente cliente = clienteRepository.findById(dto.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

            animal.setCliente(cliente);
        }

        if (dto.getNome() != null) {
            animal.setNome(dto.getNome());
        }

        if (dto.getIdade() != null) {
            animal.setIdade(dto.getIdade());
        }

        if (dto.getCategoriaAnimal() != null) {
            animal.setCategoriaAnimal(dto.getCategoriaAnimal());
        }

        return animal;
    }
}
