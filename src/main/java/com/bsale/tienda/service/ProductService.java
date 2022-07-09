package com.bsale.tienda.service;

import com.bsale.tienda.model.Category;
import com.bsale.tienda.model.Product;
import com.bsale.tienda.repository.CategoryRepository;
import com.bsale.tienda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;
    @Autowired
    private CategoryRepository category;

    public List<Product> listProduct(){
        return (List<Product>) repo.findAll();
    }
    public Optional<Product> getById(int id){
        return repo.findById(id);
    }

    public List<Product> findByTitleContaining(String name){
        var products = (List<Product>) repo.findByTitleContaining(name);
        return products;
    }

    public List<Product> findByProductCategory(int id){
        var productsCategory = (List<Product>) repo.findByProductCategory(id);
        return productsCategory;
    }

}
