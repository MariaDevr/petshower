package br.com.petshower.service;

import java.util.List;
import br.com.petshower.model.Servico;
import br.com.petshower.mapper.ServicoMapper;
import br.com.petshower.dto.response.ServicoResponseDTO;
import br.com.petshower.dto.request.ServicoRequestDTO;
import br.com.petshower.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico criar (ServicoRequestDTO dto) {

        Servico servico = new Servico();

        servico.setNome(dto.getNome());
        servico.setPreco(dto.getPreco());

        return servicoRepository.save(servico);
    }

    public List<ServicoResponseDTO> listar(){
        return servicoRepository.findAll()
                .stream()
                .map(ServicoMapper::toDTO)
                .toList();
    }

    public Servico alterar(Long id, ServicoRequestDTO dto){

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

    private Servico aplicarAtualizacaoParcial(Servico servico, ServicoRequestDTO dto){

        if(dto.getNome() != null){
            servico.setNome(dto.getNome());
        }

        if(dto.getPreco() != null){
            servico.setPreco(dto.getPreco());
        }

        return servico;
    }
}
