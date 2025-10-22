package com.user.page.pagination.specification;

import com.user.page.pagination.dao.entity.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {

  public static Specification<CustomerEntity> hasName(String name) {
    return (root, query, cb) ->
            name == null ? cb.conjunction() : cb.like(cb.lower(root.get("fullName")), "%" + name.toLowerCase() + "%");
  }

  public static Specification<CustomerEntity> hasSurName(String surName) {
    return (root, query, cb) ->
            surName == null ? cb.conjunction() : cb.like(cb.lower(root.get("surName")), "%" + surName.toLowerCase() + "%");
  }

  public static Specification<CustomerEntity> hasAge(Integer age) {
    return (root, query, cb) ->
            age == null ? cb.conjunction() : cb.equal(root.get("age"), age);
  }
}