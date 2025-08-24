package com.kailany.financeiro.core.domain.services;

import com.kailany.financeiro.core.domain.model.categoria.Categoria;
import com.kailany.financeiro.core.domain.repository.CategoriaRepository;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> buscarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long categoriaId) throws ValidationException {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);

        if (categoriaOptional.isEmpty()) {
            throw new ValidationException("Categoria não encontrada");
        }

        return categoriaOptional.get();
    }

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
