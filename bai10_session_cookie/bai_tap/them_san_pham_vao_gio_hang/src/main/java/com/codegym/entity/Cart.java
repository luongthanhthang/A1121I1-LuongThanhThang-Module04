package com.codegym.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    //kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    // tìm sản phẩm
    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    // thêm sản phẩm
    public void addProduct(Product product) {
        // nếu chưa tìm thấy sản phẩm đã có sẵn trong giỏ hàng, số lượng sản phẩm ban đầu là 1
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            // nếu có sản phẩm trong giỏ hàng rồi thì số lượng tăng thêm 1
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //đếm số lượng SẢN PHẨM hiện có trong giỏ hàng
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    // đếm SỐ LƯỢNG sản phẩm có trong giỏ hàng
    public Integer countItemQuantity() {
        return products.size();
    }

    // giảm số lượng sản phẩm trong giỏ hàng
    public void reduceProduct(Product product) {
        Map.Entry<Product, Integer> entry = selectItemInCart(product);
        int newQuantity = entry.getValue() - 1;
        products.replace(entry.getKey(), newQuantity);
    }

    // Xoá luông sản phẩm đó trong giỏ hàng
    public void deleteProduct(Product product) {
        Map.Entry<Product, Integer> entry = selectItemInCart(product);
        products.remove(entry.getKey());
    }

    // tính tổng số tiền cần phải thanh toán
    public Double countTotalPayment() {
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment = entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
