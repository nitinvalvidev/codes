package com.wcs.restapicrudapp.app.service;

import java.util.List;

import com.wcs.restapicrudapp.app.model.Product;

public interface ProductServiceI {

public	Product saveProduct(Product p);

public Product findByProductName(String productName);

public List<Product> getAllproducts();

public void deleteProduct(int pid);

public Product updateProduct(int pid, Product p);

}
