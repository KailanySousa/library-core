package com.kailany.library.core.domain.model.categoria;

public record DadosListaCategorias(Long id, String nome, String descricao, String cor) {
    public DadosListaCategorias(Categoria categoria) {
        this(categoria.getId(), categoria.getNome(), categoria.getDescricao(), categoria.getCor());
    }
}
