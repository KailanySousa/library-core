package com.kailany.library.core.domain.usecase;

import com.kailany.library.core.domain.model.categoria.Categoria;
import com.kailany.library.core.domain.model.categoria.DadosCadastroCategoria;
import com.kailany.library.core.domain.model.categoria.DadosListaCategorias;
import com.kailany.library.core.domain.services.CategoriaService;
import jakarta.xml.bind.ValidationException;
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
                .descricao(dados.descricao())
                .cor(dados.cor())
                .build();

        return categoriaService.criarCategoria(categoria);
    }

    public Categoria atualizarCategoria(Long categoriaId, DadosCadastroCategoria dados) throws ValidationException {
        Categoria categoria = this.categoriaService.buscarPorId(categoriaId);

        categoria.setNome(dados.nome());
        categoria.setDescricao(dados.descricao());
        categoria.setCor(dados.cor());

        return this.categoriaService.atualizarCategoria(categoria);
    }

    public void removerCategoria(Long categoriaId) {
        this.categoriaService.removerCategoria(categoriaId);
    }
}
