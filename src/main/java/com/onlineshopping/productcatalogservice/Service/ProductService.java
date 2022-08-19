package com.onlineshopping.productcatalogservice.Service;

import com.onlineshopping.productcatalogservice.Entity.Product;
import com.onlineshopping.productcatalogservice.Exception.ProductNotFoundException;
import com.onlineshopping.productcatalogservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();

    }

    public Product findProductById(Long productId) throws ProductNotFoundException {

        Optional<Product> productByProductId = productRepository.findByProductId(productId);

        if (productByProductId.isPresent()){
            return productByProductId.get();
        }else {
            throw new ProductNotFoundException("product with this id not found");
        }

    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
