package br.com.amr.configuration;

public interface SetupConstants {

    interface EnvironmentProperty {
        String JDBC_DRIVER_CLASS_NAME = "jdbc.driverClassName";
        String JDBC_URL = "jdbc.url";
        String JDBC_USER = "jdbc.user";
        String JDBC_PASS = "jdbc.pass";

        String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
        String HIBERNATE_DIALECT = "hibernate.dialect";

        String PRODUCT_CSV_DATA_SOURCE_FILE_PATH = "product.csv.data.source.file.path";
    }
}
