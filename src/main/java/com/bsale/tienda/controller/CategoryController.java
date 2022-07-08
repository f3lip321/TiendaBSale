package com.bsale.tienda.controller;

import com.bsale.tienda.model.Category;
import com.bsale.tienda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/test")
    public ResponseEntity<String> testGet(){
        return ResponseEntity.status(HttpStatus.OK).body("Test Get ejemplo");

    }

    @PostMapping(value = "/test")
    public ResponseEntity<String> testPost(){
        return ResponseEntity.status(HttpStatus.OK).body("Test Post ejemplo");

    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> list = service.listCategory();
        return ResponseEntity.status(HttpStatus.OK).body(list);

    }
}
