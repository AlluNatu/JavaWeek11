package com.example.javaweek11;

import java.util.ArrayList;

public class ProductStorage {
    private ArrayList<Product> products = new ArrayList<>();

    private static ProductStorage storage = null;

    private ProductStorage(){

    }

    public static ProductStorage getInstance(){
        if (storage == null){
            storage = new ProductStorage();
        }
        return storage;
    }

    public void addProduct(Product product) {products.add(product);}

    public ArrayList<Product> getProducts() {return products; }

    public void removeProduct(String id) {
        int i = 0;
        for (Product p : products){
            if (p.getId().equals(id)) {
                break;
            }
            i++;
        }
        products.remove(i);
    }

    public Product getProductById(int id) {
        return products.get(id);
    }


}
