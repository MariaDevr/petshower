package br.com.petshower.service;

import br.com.petshower.model.Animal;
import br.com.petshower.model.Atendimento;

import java.util.List;
import br.com.petshower.dto.AtendimentoCreateDTO;
import br.com.petshower.repository.AnimalRepository;
import br.com.petshower.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public Atendimento criar (AtendimentoCreateDTO dto) {
        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        Atendimento atendimento = new Atendimento();
        atendimento.setAnimal(animal);
        atendimento.setData(dto.getData());
        atendimento.setStatus(dto.getStatus());
        atendimento.setEntrega(dto.getEntrega());
        atendimento.setDescricao(dto.getDescricao());

        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listar(){
        return atendimentoRepository.findAll();
    }

    public Atendimento alterar(Long id, AtendimentoCreateDTO dto){

        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));

        aplicarAtualizacaoParcial(atendimento, dto);

        return atendimentoRepository.save(atendimento);
    }

    public Atendimento buscarPorId(Long id) {
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }

    public void excluir(Long id) {

        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));

        atendimentoRepository.delete(atendimento);
    }

    private Atendimento aplicarAtualizacaoParcial(Atendimento atendimento, AtendimentoCreateDTO dto){

        if (dto.getAnimalId() != null){

            Animal animal = animalRepository.findById(dto.getAnimalId())
                    .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

            atendimento.setAnimal(animal);
        }

        if (dto.getData() != null){
            atendimento.setData(dto.getData());
        }

        if (dto.getEntrega() != null){
            atendimento.setEntrega(dto.getEntrega());
        }

        if (dto.getDescricao() != null){
            atendimento.setDescricao(dto.getDescricao());
        }

        if (dto.getStatus() != null){
            atendimento.setStatus(dto.getStatus());
        }


        return atendimento;
    }
}
