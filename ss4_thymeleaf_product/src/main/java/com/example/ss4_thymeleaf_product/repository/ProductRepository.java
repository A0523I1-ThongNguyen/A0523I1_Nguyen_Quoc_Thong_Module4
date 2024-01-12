package com.example.ss4_thymeleaf_product.repository;

import com.example.ss4_thymeleaf_product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    public static List<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product(1, "keo", 5000, "ngot", "bibica"));
        listProduct.add(new Product(2, "banh", 8000, "trung", "baongoc"));
        listProduct.add(new Product(3, "coca", 10000, "co gas", "cocacola"));
    }


    @Override
    public List<Product> findAll() {
        return listProduct;
    }

    @Override
    public void add(Product product) {
        listProduct.add(product);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                listProduct.remove(i);
            }
        }
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                listProduct.set(i, product);
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                return listProduct.get(i);
            }
        }

        return null;
    }

    @Override
    public List<Product> listSearch(String name) {
        List<Product> listSearch = new ArrayList<>();
        for (int i = 0; i < listProduct.size();i++){
            if (listProduct.get(i).getName().equals(name)){
                listSearch.add(listProduct.get(i));
            }
        }
        return listSearch;
    }
}
