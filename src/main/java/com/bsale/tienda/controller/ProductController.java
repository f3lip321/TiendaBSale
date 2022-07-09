package com.bsale.tienda.controller;

import com.bsale.tienda.model.Category;
import com.bsale.tienda.model.Product;
import com.bsale.tienda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Product>> listProduct(){
        List<Product> list = service.listProduct();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = service.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping(value = "/findByTitleContaining/{name}")
    public ResponseEntity findProductsNameEndsWith(@PathVariable String name) {

        var products = (List<Product>) service.findByTitleContaining(name);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(value = "/showProductCategory/{id}")
    public ResponseEntity findByProductCategory(@PathVariable int id) {

        var products = (List<Product>) service.findByProductCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
