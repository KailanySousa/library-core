package com.kailany.financeiro.core.domain.usecase;

import com.kailany.financeiro.core.domain.model.categoria.Categoria;
import com.kailany.financeiro.core.domain.model.categoria.DadosCadastroCategoria;
import com.kailany.financeiro.core.domain.model.categoria.DadosListaCategorias;
import com.kailany.financeiro.core.domain.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaUseCase {

    @Autowired
    private CategoriaService categoriaService;

    public List<DadosListaCategorias> buscarCategorias() {
        return categoriaService.buscarCategorias().stream().map(DadosListaCategorias::new).toList();
    }

    public Categoria criarCategoria(DadosCadastroCategoria dados) {
        Categoria categoria = Categoria
                .builder()
                .nome(dados.nome())
                .build();

        return categoriaService.criarCategoria(categoria);
    }
}
