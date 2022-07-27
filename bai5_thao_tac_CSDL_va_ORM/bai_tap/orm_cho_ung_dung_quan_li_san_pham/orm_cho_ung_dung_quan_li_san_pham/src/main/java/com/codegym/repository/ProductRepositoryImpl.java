package com.codegym.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.codegym.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = entityManager
                .createQuery("select p from Product p")
                .getResultList();
        // Native SQL
//        students = entityManager
//                .createNativeQuery("select * from Student")
//                .getResultList();
        return productList;
    }

    @Modifying
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }


    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Modifying
    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Modifying
    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = entityManager
                .createQuery("select p from Product p where p.name like :name").setParameter("name",name).getResultList();
       return productList;
    }
}
