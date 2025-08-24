package com.kailany.financeiro.adapter.input.controller;

import com.kailany.financeiro.core.domain.model.categoria.Categoria;
import com.kailany.financeiro.core.domain.model.categoria.DadosCadastroCategoria;
import com.kailany.financeiro.core.domain.model.categoria.DadosDetalhesCategoria;
import com.kailany.financeiro.core.domain.model.categoria.DadosListaCategorias;
import com.kailany.financeiro.core.domain.usecase.CategoriaUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaUseCase categoriaUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhesCategoria> cadastrar(
            @RequestBody @Valid DadosCadastroCategoria dados,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Categoria categoria = categoriaUseCase.criarCategoria(dados);
        var uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhesCategoria(categoria));
    }

    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok(categoriaUseCase.buscarCategorias());
    }
}
