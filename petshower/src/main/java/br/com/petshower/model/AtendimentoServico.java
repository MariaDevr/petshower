package br.com.petshower.model;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class AtendimentoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn( name = "servico_id")
    private Servico servico;

    @ManyToOne
    @JoinColumn( name = "atendimento_id")
    private Atendimento atendimento;

    private Float preco_dia;
    private String descricao;

}
