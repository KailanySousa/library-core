package com.kailany.financeiro.core.domain.model.categoria;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "categorias")
@Entity(name = "Categorias")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
    }
}
