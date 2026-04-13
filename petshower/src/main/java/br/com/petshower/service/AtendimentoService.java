package br.com.petshower.service;

import br.com.petshower.model.Atendimento;
import br.com.petshower.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Atendimento criar (Atendimento atendimento){
        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listar(){
        return atendimentoRepository.findAll();
    }

    public Atendimento alterar(Long id, Atendimento atendimentoAtualizado){

        Atendimento atendimento = buscarPorId(id);

        atendimento.setData(atendimentoAtualizado.getData());
        atendimento.setEntrega(atendimentoAtualizado.getEntrega());
        atendimento.setStatus(atendimentoAtualizado.getStatus());

        return atendimentoRepository.save(atendimento);
    }

    public Atendimento buscarPorId(Long id) {
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }

    public void excluir(Long id) {
        atendimentoRepository.deleteById(id);
    }

}
