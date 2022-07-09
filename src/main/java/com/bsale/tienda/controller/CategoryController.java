package com.bsale.tienda.controller;

import com.bsale.tienda.model.Category;
import com.bsale.tienda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> list = service.listCategory();
        return ResponseEntity.status(HttpStatus.OK).body(list);

    }
}
