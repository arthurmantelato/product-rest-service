package br.com.amr.repository;

import br.com.amr.entity.Product;
import br.com.amr.util.ProductCsvToObjectTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.amr.configuration.SetupConstants.EnvironmentProperty.PRODUCT_CSV_DATA_SOURCE_FILE_PATH;

@Repository
public class ProductCsvRepository implements PagingAndSortingRepository<Product, Long> {

    private Map<Long, Product> products;
    private Environment env;

    @Autowired
    public ProductCsvRepository(Environment env) throws IOException {
        this.env = env;
        loadProductsFromCsvDataSource();
    }

    private void loadProductsFromCsvDataSource() throws IOException {
        final String delimiter = ";";
        products = Files.readAllLines(Paths.get(env.getProperty(PRODUCT_CSV_DATA_SOURCE_FILE_PATH)))
                .stream()
                .skip(1) /* Skip header line */
                .map(csvValue -> ProductCsvToObjectTransformer.transform(csvValue, delimiter))
                .collect(Collectors.toMap(p -> p.getId(), p -> p, (p1, p2) -> p2));
    }

    @Override
    public Iterable<Product> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public <S extends Product> S save(S s) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.containsKey(id) ? Optional.of(products.get(id)) : Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Iterable<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void delete(Product product) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
