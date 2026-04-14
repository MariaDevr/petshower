package br.com.petshower.model;

import lombok.*;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @Email
    private String email;

    @NotNull
    @Column(nullable = false)
    private String cpf;

    private String endereco;
}
