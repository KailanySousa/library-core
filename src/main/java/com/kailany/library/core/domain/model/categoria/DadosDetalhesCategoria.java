package com.kailany.library.core.domain.model.categoria;

public record DadosDetalhesCategoria(String nome) {
    public DadosDetalhesCategoria(Categoria categoria) {
        this(categoria.getNome());
    }
}
