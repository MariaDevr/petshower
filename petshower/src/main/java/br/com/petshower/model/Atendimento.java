package br.com.petshower.model;
import br.com.petshower.enums.StatusAtendimento;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @OneToMany(mappedBy="atendimento")
    private Set<AtendimentoServico> atendimentoServicos;

    private Date data;
    private Boolean entrega;
    @Enumerated(EnumType.STRING)
    private StatusAtendimento status;

}
