package br.com.petshower.service;

import br.com.petshower.dto.ServicoCreateDTO;
import br.com.petshower.model.Servico;
import br.com.petshower.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico criar (ServicoCreateDTO dto) {

        Servico servico = new Servico();

        servico.setNome(dto.getNome());
        servico.setPreco(dto.getPreco());

        return servicoRepository.save(servico);
    }

    public List<Servico> listar(){
        return servicoRepository.findAll();
    }

    public Servico alterar(Long id, ServicoCreateDTO dto){

        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        aplicarAtualizacaoParcial(servico, dto);

        return servicoRepository.save(servico);
    }

    public Servico buscarPorId(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public void excluir(Long id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        servicoRepository.deleteById(id);
    }

    private Servico aplicarAtualizacaoParcial(Servico servico, ServicoCreateDTO dto){

        if(dto.getNome() != null){
            servico.setNome(dto.getNome());
        }

        if(dto.getPreco() != null){
            servico.setPreco(dto.getPreco());
        }

        return servico;
    }
}
