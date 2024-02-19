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
        listProduct.add(new Product(4, "coca", 8000, "co gas", "cocacola"));
        listProduct.add(new Product(4,"sting",11000,"dau","vn"));

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
            if (listProduct.get(i).getId() == id) { // get đối tượng index 0 lấy id 1 ra == id
                listProduct.set(i, product); // set tại index i bằng product mới
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
      for (Product productFound : listProduct){
          if (productFound.getName().equalsIgnoreCase(name)){
              listSearch.add(productFound);
          }
      }
        return listSearch;
    }

    @Override
    public List<Product> listSearch2(String name){
        List<Product> listSearch2 = new ArrayList<>();
        for (int i = 0; i <listProduct.size();i++){
            if (listProduct.get(i).getName().equalsIgnoreCase(name)){
                listSearch2.add(listProduct.get(i));
            }
        }
        return listSearch2;
    }
}
