package com.kailany.library.adapter.input.controller;

import com.kailany.library.core.domain.model.categoria.Categoria;
import com.kailany.library.core.domain.model.categoria.DadosCadastroCategoria;
import com.kailany.library.core.domain.usecase.CategoriaUseCase;
import jakarta.validation.Valid;
import jakarta.xml.bind.ValidationException;
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
    public ResponseEntity cadastrar(
            @RequestBody @Valid DadosCadastroCategoria dados,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Categoria categoria = categoriaUseCase.criarCategoria(dados);
        var uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok(categoriaUseCase.buscarCategorias());
    }

    @PutMapping("/{categoriaId}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long categoriaId, @RequestBody @Valid DadosCadastroCategoria dados,UriComponentsBuilder uriComponentsBuilder) throws ValidationException {
        Categoria categoria = categoriaUseCase.atualizarCategoria(categoriaId, dados);
        var uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
