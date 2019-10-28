package br.com.amr.util;

import br.com.amr.entity.Product;

public class ProductCsvToObjectTransformer {

    public static Product transform(String productAsCsv, String delimiter) {
        String[] productData = productAsCsv.split(delimiter);
        ProductBuilder builder = new ProductBuilder();
        return builder
                .withId(productData[0])
                .withName(productData[1])
                .withCurrentPrice(productData[2])
                .withOldPrice(productData[3])
                .withQuantity(productData[4])
                .withBrand(productData[5])
                .build();
    }
}
