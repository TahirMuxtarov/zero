package com.example.onetomany.search;

import com.example.onetomany.entity.Actor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ActorSpecificationBuilder {
    private List<SearchCriteria> params;

    public ActorSpecificationBuilder with(
            String key, String operation, Object value, String prefix, String suffix) {

        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) {
                boolean startWithAsterisk = prefix.contains("*");
                boolean endWithAsterisk = suffix.contains("*");

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SearchCriteria(key, op, value));
        }
        return this;
    }

    public Specification<Actor> build() {
        if (params.size() == 0) {
            return null;
        }

        Specification result = new ActorSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new ActorSpecification(params.get(i)))
                    : Specification.where(result).and(new ActorSpecification(params.get(i)));
        }

        return result;
    }
}
