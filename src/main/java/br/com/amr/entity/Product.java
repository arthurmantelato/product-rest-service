package br.com.amr.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {

    @Id
    private Long id;
    private String name;
    private Double currentPrice;
    private Double oldPrice;
    private Integer quantity;
    private String brand;

    public Product(Long id, String name, Double currentPrice, Double oldPrice, Integer quantity, String brand) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
        this.oldPrice = oldPrice;
        this.quantity = quantity;
        this.brand = brand;
    }

    public Product(){}

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Product of(Long id, String name, Double currentPrice, Double oldPrice, Integer quantity, String brand) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCurrentPrice(currentPrice);
        product.setOldPrice(oldPrice);
        product.setQuantity(quantity);
        product.setBrand(brand);
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                name.equals(product.name) &&
                currentPrice.equals(product.currentPrice) &&
                oldPrice.equals(product.oldPrice) &&
                quantity.equals(product.quantity) &&
                brand.equals(product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentPrice, oldPrice, quantity, brand);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", oldPrice=" + oldPrice +
                ", quantity=" + quantity +
                ", brand='" + brand + '\'' +
                '}';
    }
}
