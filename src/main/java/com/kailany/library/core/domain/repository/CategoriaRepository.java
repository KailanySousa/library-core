package com.kailany.financeiro.core.domain.repository;

import com.kailany.financeiro.core.domain.model.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
