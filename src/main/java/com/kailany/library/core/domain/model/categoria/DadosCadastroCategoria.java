package com.kailany.library.core.domain.model.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(@NotBlank String nome, String descricao, String cor) {
}
