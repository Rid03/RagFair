package dev.gorito.service;

import dev.gorito.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Getter
    private List<Product> products = new ArrayList<>();

    public void saveProduct(Product product) {
        product.setId(product.getId());
        products.add(product);
    }

    public void deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID не может быть без значения");
        }
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Товар не найден");
        }
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
