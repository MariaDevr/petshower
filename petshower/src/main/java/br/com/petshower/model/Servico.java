package br.com.petshower.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy="servico")
    private Set<AtendimentoServico> AtendimentoServicos;

    private String nome;
    private Float preco;
}
