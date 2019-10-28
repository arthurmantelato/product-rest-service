package br.com.amr.util;

import br.com.amr.entity.Product;

public class ProductBuilder {

    private Long id;
    private String name;
    private Double currentPrice;
    private Double oldPrice;
    private Integer quantity;
    private String brand;

    public ProductBuilder() {
    }

    public ProductBuilder withId(String id) {
        this.id = Long.parseLong(id);
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withCurrentPrice(String currentPrice) {
        this.currentPrice = Double.parseDouble(currentPrice);
        return this;
    }

    public ProductBuilder withOldPrice(String oldPrice) {
        this.oldPrice = Double.parseDouble(oldPrice);
        return this;
    }

    public ProductBuilder withQuantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
        return this;
    }

    public ProductBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Product build() {
        return Product.of(id, name, currentPrice, oldPrice, quantity, brand);
    }
}
