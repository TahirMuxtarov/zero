package com.example.onetomany.search;

import com.example.onetomany.entity.Actor;
//import com.example.onetomany.entity.Actor_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static com.example.onetomany.search.SearchOperation.*;


public class ActorSpecification implements Specification<Actor> {

    @Autowired
    private SearchCriteria criteria;

    public ActorSpecification(SearchCriteria searchCriteria) {
    }

    @Override
    public Predicate toPredicate(
            Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        switch (criteria.getSearchOperation()) {
            case EQUALITY:
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            case NEGATION:
                return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN:
                return builder.greaterThan(root.get(
                        criteria.getKey()), criteria.getValue().toString());
            case LESS_THAN:
                return builder.lessThan(root.get(
                        criteria.getKey()), criteria.getValue().toString());
            case LIKE:
                return builder.like(root.get(
                        criteria.getKey()), criteria.getValue().toString());
            case STARTS_WITH:
                return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
            case ENDS_WITH:
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
            case CONTAINS:
                return builder.like(root.get(
                        criteria.getKey()), "%" + criteria.getValue() + "%");
            default:
                return null;
        }
    }

    /*public static Specification<Actor> likeFirstName(String name){
        if(name==null){
            return null;
        }
        return (root, query, criteriaBuilder) -> {
          return criteriaBuilder.like(root.get(Actor_.NAME),"%"+name+"%");
        };
    }
    public static Specification<Actor> ageLessThan(Integer age){
        if(age==null){
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThan(root.get(Actor_.AGE),age);
        };
    }*/

}
