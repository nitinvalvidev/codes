package com.wcs.restapicrudapp.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.restapicrudapp.app.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
	
	public Product findByProductName(String productName);

}
