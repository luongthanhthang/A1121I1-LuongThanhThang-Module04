package com.codegym.repository;

import com.codegym.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static Map<String, Product> productMap = new HashMap<>();

//    static {
//        productMap.put("MILK001", new Product("MILK001", "sữa vinamilk", "ít đường"));
//        productMap.put("MILK002", new Product("MILK002", "sữa milô", "không đường"));
//        productMap.put("BREAD001", new Product("BREAD001", "bánh mì bình dân", "full-topping"));
//        productMap.put("BREAD002", new Product("BREAD002", "bánh mì thượng đẳng", "full-full-topping"));
//        productMap.put("CAKE001", new Product("CAKE001", "bánh crepe sầu riêng", "full sầu riêng"));
//    }

    @Override
    public void create(Product product) {
        // kiểm tra trong list có trung mã sản phẩm không
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void update(Product product) {
        // kiểm tra trong list có trung mã sản phẩm không
        if (productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void delete(String id) {
        if (productMap.containsKey(id)) {
            productMap.remove(id);
        }
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>(productMap.values());
        List<Product> productListName = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                productListName.add(product);
            }
        }
        if (productListName.isEmpty()) {
            productListName = productList;
        }
        return productListName;
    }
}
