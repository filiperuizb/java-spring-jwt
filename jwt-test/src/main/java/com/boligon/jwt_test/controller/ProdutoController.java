package com.boligon.jwt_test.controller;

import com.boligon.jwt_test.models.Produto;
import com.boligon.jwt_test.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> bookEntities = produtoService.findAll();
        return ResponseEntity.ok().body(bookEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Optional<Produto> bookModel = produtoService.findById(id);
        if(bookModel.isPresent()){
            return ResponseEntity.ok().body(bookModel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto Produto){
        Produto book = produtoService.save(Produto);
        return ResponseEntity.status(201).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        produtoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
