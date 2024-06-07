package dev.gorito.service;

import dev.gorito.model.Product;
import dev.gorito.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        if (title != null) {
            productRepository.findByTitle(title);
        }
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID не может быть без значения");
        }
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return productRepository.findById(id).orElse(null);
    }
}
