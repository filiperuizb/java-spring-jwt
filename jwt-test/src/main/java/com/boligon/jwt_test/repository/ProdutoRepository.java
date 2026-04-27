package com.boligon.jwt_test.repository;

import com.boligon.jwt_test.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
