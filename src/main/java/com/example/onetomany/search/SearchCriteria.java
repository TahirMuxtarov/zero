package com.example.onetomany.search;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private SearchOperation searchOperation;
    private Object value;

    public boolean isOrPredicate() {
        return false;
    }

    public SearchCriteria(String key, SearchOperation searchOperation) {
        this.key = key;
        this.searchOperation = searchOperation;
    }

    public SearchCriteria(SearchOperation searchOperation, Object value) {
        this.searchOperation = searchOperation;
        this.value = value;
    }
}
