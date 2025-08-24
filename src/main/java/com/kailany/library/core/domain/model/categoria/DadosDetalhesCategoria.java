package com.kailany.financeiro.core.domain.model.categoria;

public record DadosDetalhesCategoria(String nome) {
    public DadosDetalhesCategoria(Categoria categoria) {
        this(categoria.getNome());
    }
}
