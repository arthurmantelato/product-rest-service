package br.com.amr.controller;

import br.com.amr.entity.Product;
import br.com.amr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
public class ProductRestController {

    private ProductService service;

    @Autowired
    public ProductRestController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/products")
    public Page<Product> findAll(@RequestParam(name = "pageNumber") Optional<Integer> pageNumber,
                              @RequestParam(name = "pageSize") Optional<Integer> pageSize,
                              @RequestParam(name = "sortCriteria") Optional<String> sortCriteria,
                              @RequestParam(name = "sortDirection") Optional<String> sortDirection) {
        PageRequest pageRequest = PaginationAndSortingUtil.resolve(pageNumber, pageSize, sortCriteria, sortDirection);
        return service.findAll(pageRequest);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Optional<Product> product = service.findById(id);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
        }
    }
}
