package com.bsale.tienda.repository;

import com.bsale.tienda.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select c from Product c where c.name like %?1%")
    List<Product> findByTitleContaining(String chars);

    //Listar Productos por Category
    @Query("select p from Product p inner join Category c on p.category.id = c.id where p.category.id = ?1")
    List<Product> findByProductCategory(int id);

}
