package com.practice.httpstatus.httpstatus.specification;


import com.practice.httpstatus.httpstatus.dao.entity.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {
  public static Specification<CustomerEntity> hasName(String name) {
    return (root, query, cb) ->
            name == null ? cb.conjunction() : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
  }

  public static Specification<CustomerEntity> hasSurName(String surName) {
    return (root, query, cb) ->
            surName == null ? cb.conjunction() : cb.like(cb.lower(root.get("surName")), "%" + surName.toLowerCase() + "%");
  }

  public static Specification<CustomerEntity> hasEmail(String email) {
    return (root, query, cb) ->
            email == null ? cb.conjunction() : cb.equal(root.get("email"), email);
  }

  public static Specification<CustomerEntity> hasPassword(String password){
    return (root, query, cb) ->
            password == null ? cb.conjunction() : cb.equal(root.get("password"), password);
  }
}
