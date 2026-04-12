package br.com.petshower.service;

import br.com.petshower.model.Servico;
import br.com.petshower.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico criar (Servico servico){
        return servicoRepository.save(servico);
    }

    public List<Servico> listar(){
        return servicoRepository.findAll();
    }

    public Servico buscarPorID(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public void excluir(Long id) {
        servicoRepository.deleteById(id);
    }
}
