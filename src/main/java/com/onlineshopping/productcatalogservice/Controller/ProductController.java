package com.onlineshopping.productcatalogservice.Controller;

import com.onlineshopping.productcatalogservice.Entity.Product;
import com.onlineshopping.productcatalogservice.Exception.ProductNotFoundException;
import com.onlineshopping.productcatalogservice.Service.ProductService;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        return  new ResponseEntity<>(productService.findProductById(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return  new ResponseEntity<>(productService.saveProduct(product),HttpStatus.OK);
    }
}
