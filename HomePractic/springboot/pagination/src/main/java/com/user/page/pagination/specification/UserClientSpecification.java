package com.user.page.pagination.specification;

import com.user.page.pagination.dao.entity.UserClientEntity;
import com.user.page.pagination.dto.UserClientResponseDto;
import org.springframework.data.jpa.domain.Specification;

public class UserClientSpecification {

  public static Specification<UserClientEntity> hasName(String fullName) {
    return (root, query, cb) ->
            fullName == null ? cb.conjunction() :
                    cb.like(cb.lower(root.get("fullName")), "%" + fullName.toLowerCase() + "%");
  }

  public static Specification<UserClientEntity> hasSurName(String surName) {
    return (root, query, cb) ->
            surName == null ? cb.conjunction():
                    cb.like(cb.lower(root.get(surName)),"%"+ surName.toLowerCase() + "%");
  }

}
