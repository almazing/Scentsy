package com.example.demo.entity.products;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class ProductController {

    @Autowired
    private ProductRepository ProductRepository;

    @GetMapping(path = "/products")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Product getProduct(@PathVariable(value = "id") Integer id) {
        Optional<Product> Product = ProductRepository.findById(id);
        return Product.get();
    }

    @PostMapping(path = "/products")
    public @ResponseBody String createProduct(@RequestBody Product Product) {
        ProductRepository.save(Product);
        return "Saved";
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateProduct(@PathVariable(value = "id") Integer id, @RequestBody Product ProductDetails) {

        Optional<Product> optionalProduct = ProductRepository.findById(id);
        Product Product = optionalProduct.get();

        Product.setProductDescription(ProductDetails.getProductDescription());
        Product.setProductName(ProductDetails.getProductName());
        Product.setProductPrice(ProductDetails.getProductPrice());

        ProductRepository.save(ProductDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteProduct(@PathVariable(value = "id") Integer id) {
        ProductRepository.deleteById(id);
        return "Deleted";
    }
}
