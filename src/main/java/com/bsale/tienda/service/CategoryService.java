package com.bsale.tienda.service;

import com.bsale.tienda.model.Category;
import com.bsale.tienda.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> listCategory(){
        return (List<Category>) repo.findAll();
    }
}
