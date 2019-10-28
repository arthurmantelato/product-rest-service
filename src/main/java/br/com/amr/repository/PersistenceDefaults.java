package br.com.amr.repository;

public interface PersistenceDefaults {

    interface Pagination {
        int DEFAULT_PAGE_NUMBER = 0;
        int DEFAULT_PAGE_SIZE = 10;
        int MAX_PAGE_SIZE = 100;
    }

    interface Sorting {
        String DEFAULT_SORTING_CRITERIA = "id";
        String DEFAULT_SORTING_DIRECTION = "ASC";
    }
}
