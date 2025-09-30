package com.spec.pageandspecification.specification;

import com.spec.pageandspecification.dao.entity.CarEntity;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecification {
  public static Specification<CarEntity> hasMark(String mark) {
    return (root, query, cb) ->
            mark == null ? cb.conjunction() : cb.like(cb.lower(root.get("mark")),
             "%" + mark.toLowerCase() + "%" );
  }

  public static Specification<CarEntity> hasModel(String model) {
    return (root, query, cb) ->
            model == null ? cb.conjunction() : cb.like(cb.lower(root.get("model")),
                    "%" + model.toLowerCase() + "%" );
  }

  public static Specification<CarEntity> hasYear(Integer year) {
    return (root, query, cb) ->
            year == null ? cb.conjunction() : cb.equal(root.get("year"),year);
  }

  public static Specification<CarEntity> hasFuel(String fuelType) {
    return (root, query, cb) ->
            fuelType == null ? cb.conjunction() : cb.like(cb.lower(root.get("fuelType")),
                    "%" + fuelType.toLowerCase() + "%");
  }
}
