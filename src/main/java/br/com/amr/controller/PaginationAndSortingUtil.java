package br.com.amr.controller;

import br.com.amr.repository.PersistenceDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class PaginationAndSortingUtil {

    public static PageRequest resolve(Optional<Integer> pageNumber,
                                      Optional<Integer> pageSize,
                                      Optional<String> sortCriteria,
                                      Optional<String> sortDirection) {
        int page = pageNumber.orElse(PersistenceDefaults.Pagination.DEFAULT_PAGE_NUMBER);
        int size = Math.min(pageSize.orElse(PersistenceDefaults.Pagination.DEFAULT_PAGE_SIZE),
                            PersistenceDefaults.Pagination.MAX_PAGE_SIZE);
        String sort = sortCriteria.orElse(PersistenceDefaults.Sorting.DEFAULT_SORTING_CRITERIA);
        Sort.Direction sortDir = Sort.Direction.fromString(sortDirection.orElse(PersistenceDefaults.Sorting.DEFAULT_SORTING_DIRECTION));
        return PageRequest.of(page, size, sortDir, sort);
    }
}
