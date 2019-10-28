package br.com.amr.service;

import br.com.amr.entity.Product;
import br.com.amr.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductJpaRepository repository;

    @Autowired
    public ProductService(ProductJpaRepository repository) {
        this.repository = repository;
    }

    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
