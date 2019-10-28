package br.com.amr.controller;

import br.com.amr.repository.PersistenceDefaults;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PaginationAndSortingUtilTest {

    @Test
    public void testWhenPageNumberIsNotInformedThenDefaultPageNumberShouldBeUsed() {
        Optional<Integer> pageNumber = Optional.empty();
        Optional<Integer> pageSize = Optional.of(10);
        Optional<String> sortCriteria = Optional.of("name");
        Optional<String> sortDirection = Optional.of("DESC");
        PageRequest actual = PaginationAndSortingUtil.resolve(pageNumber, pageSize, sortCriteria, sortDirection);
        assertThat(actual).isEqualTo(PageRequest.of(PersistenceDefaults.Pagination.DEFAULT_PAGE_NUMBER, 10, Sort.Direction.DESC, "name"));
    }

    @Test
    public void testWhenPageSizeIsNotInformedThenDefaultPageNumberShouldBeUsed() {
        Optional<Integer> pageNumber = Optional.of(5);
        Optional<Integer> pageSize = Optional.empty();
        Optional<String> sortCriteria = Optional.of("name");
        Optional<String> sortDirection = Optional.of("DESC");
        PageRequest actual = PaginationAndSortingUtil.resolve(pageNumber, pageSize, sortCriteria, sortDirection);
        assertThat(actual).isEqualTo(PageRequest.of(5, PersistenceDefaults.Pagination.DEFAULT_PAGE_SIZE, Sort.Direction.DESC, "name"));
    }

    @Test
    public void testWhenPageSizeIsGreaterThanMaxPageSizeThenMaxPageSizeConfigurationShouldBeUsed() {
        Optional<Integer> pageNumber = Optional.of(5);
        Optional<Integer> pageSize = Optional.of(Integer.MAX_VALUE);
        Optional<String> sortCriteria = Optional.of("name");
        Optional<String> sortDirection = Optional.of("DESC");
        PageRequest actual = PaginationAndSortingUtil.resolve(pageNumber, pageSize, sortCriteria, sortDirection);
        assertThat(actual).isEqualTo(PageRequest.of(5, PersistenceDefaults.Pagination.MAX_PAGE_SIZE, Sort.Direction.DESC, "name"));
    }

    @Test
    public void testWhenSortCriteriaIsNotInformedThenDefaultSortCriteriaShouldBeUsed() {
        Optional<Integer> pageNumber = Optional.of(5);
        Optional<Integer> pageSize = Optional.of(10);
        Optional<String> sortCriteria = Optional.empty();
        Optional<String> sortDirection = Optional.of("DESC");
        PageRequest actual = PaginationAndSortingUtil.resolve(pageNumber, pageSize, sortCriteria, sortDirection);
        assertThat(actual).isEqualTo(PageRequest.of(5, 10, Sort.Direction.DESC, PersistenceDefaults.Sorting.DEFAULT_SORTING_CRITERIA));
    }

    @Test
    public void testWhenSortDirectionIsNotInformedThenDefaultSortDirectionShouldBeUsed() {
        Optional<Integer> pageNumber = Optional.of(5);
        Optional<Integer> pageSize = Optional.of(10);
        Optional<String> sortCriteria = Optional.of("name");
        Optional<String> sortDirection = Optional.empty();
        PageRequest actual = PaginationAndSortingUtil.resolve(pageNumber, pageSize, sortCriteria, sortDirection);
        assertThat(actual).isEqualTo(PageRequest.of(5, 10, Sort.Direction.fromString(PersistenceDefaults.Sorting.DEFAULT_SORTING_DIRECTION), "name"));
    }

}