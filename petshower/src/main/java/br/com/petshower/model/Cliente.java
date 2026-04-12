package br.com.petshower.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="cliente")
    private Set<Animal> animais;

    private String nome;
    private String email;
    private String cpf;
    private String endereco;
}
