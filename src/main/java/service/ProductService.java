package service;

import Entity.Product;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product update(Product product){
        return repository.save(product);
    }

    public Product add(Product product){
        return  repository.save(product);
    }

    public void delete(Product product){
        repository.delete(product);
    }
}
