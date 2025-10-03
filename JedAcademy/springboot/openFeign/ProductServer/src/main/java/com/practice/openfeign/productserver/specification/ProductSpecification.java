package com.practice.openfeign.productserver.specification;

import com.practice.openfeign.productserver.dao.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
  public static Specification<ProductEntity> hasTitle(String title) {
    return (root, query, cb) ->
            title == null ? cb.conjunction() : cb.like(cb.lower(root.get("title")), "%" + title + "%");
  }

  public static Specification<ProductEntity> hasPrice(Double price) {
    return (root, query, cb) ->
            price == null ? cb.conjunction() : cb.equal(root.get("price"), price);
  }

  public static Specification<ProductEntity> hasStock(Integer stock) {
    return (root, query, cb) ->
            stock == null ? cb.conjunction() : cb.equal(root.get("stock"), stock);
  }
}
