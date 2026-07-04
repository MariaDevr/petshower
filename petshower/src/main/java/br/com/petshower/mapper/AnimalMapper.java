package br.com.petshower.mapper;

import br.com.petshower.model.Animal;
import org.springframework.stereotype.Component;
import br.com.petshower.dto.response.AnimalResponseDTO;

@Component
public class AnimalMapper {

    public static AnimalResponseDTO toDTO(Animal animal) {
        AnimalResponseDTO dto = new AnimalResponseDTO();
        dto.setId(animal.getId());
        dto.setNome(animal.getNome());
        dto.setIdade(animal.getIdade());
        return dto;
    }

}