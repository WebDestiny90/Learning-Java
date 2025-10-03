package com.spec.specification.specification;

import com.spec.specification.dao.entity.GameEntity;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecification {

  public static Specification<GameEntity> hasTitle(String title) {
    return (root, query, cb) ->
            title == null ? cb.conjunction() :
                    cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
  }

  public static Specification<GameEntity> hasGenre(String genre) {
    return (root, query, cb) ->
            genre == null ? cb.conjunction() :
                    cb.equal(root.get("genre"), genre);
  }

  public static Specification<GameEntity> priceGreaterThan(Double minPrice) {
    return (root, query, cb) ->
            minPrice == null ? cb.conjunction() :
                    cb.greaterThanOrEqualTo(root.get("price"), minPrice);
  }

  public static Specification<GameEntity> priceLessThan(Double maxPrice) {
    return (root, query, cb) ->
            maxPrice == null ? cb.conjunction() :
                    cb.lessThanOrEqualTo(root.get("price"), maxPrice);
  }

  public static Specification<GameEntity> releaseYearIs(Integer releaseYear) {
    return (root, query, cb) ->
            releaseYear == null ? cb.conjunction() :
                    cb.equal(root.get("releaseYear"), releaseYear);
  }
  }

