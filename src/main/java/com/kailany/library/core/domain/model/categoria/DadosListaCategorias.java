package com.kailany.financeiro.core.domain.model.categoria;

public record DadosListaCategorias(Long id, String nome) {
    public DadosListaCategorias(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }
}
