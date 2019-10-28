package br.com.amr.util;

import br.com.amr.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ProductCsvToObjectTransformerTest {

    @Test
    public void testTransformWhenCsvValueIsValidThenValidObjectShouldBeCreated() {
        String csv = "43664;LEGO #14362905;24.99;29.99;0;LEGO";
        String delimiter = ";";
        ProductBuilder builder = new ProductBuilder();
        Product expected = builder.withId("43664")
                .withName("LEGO #14362905")
                .withCurrentPrice("24.99")
                .withOldPrice("29.99")
                .withQuantity("0")
                .withBrand("LEGO")
                .build();
        Product actual = ProductCsvToObjectTransformer.transform(csv, delimiter);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}