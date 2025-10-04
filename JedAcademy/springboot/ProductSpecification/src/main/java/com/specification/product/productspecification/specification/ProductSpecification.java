package com.specification.product.productspecification.specification;

import com.specification.product.productspecification.dao.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductSpecification {
  public static Specification<ProductEntity> hasTitle(String title){
    return (root, query, cb) ->
            title == null ? cb.conjunction() : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
  }

  public static Specification<ProductEntity> hasPriceLess(BigDecimal price) {
    return (root, query, cb) ->
            price == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get("price"),price);
  }

  public static Specification<ProductEntity> hasPriceGreater(BigDecimal price) {
    return (root, query, cb) ->
            price == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("price"),price);
  }

  public static Specification<ProductEntity> hasStockLess(Integer stock) {
    return (root, query, cb) ->
            stock == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get("stock"),stock);
  }

  public static Specification<ProductEntity> hasStockGreater(Integer stock) {
    return (root, query, cb) ->
            stock == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("stock"),stock);
  }

  public static Specification<ProductEntity> hasBrand(String brand) {
    return (root, query, cb) ->
            brand == null ? cb.conjunction() : cb.equal(root.get("brand"), brand);
  }

  public static Specification<ProductEntity> hasCategory(String category) {
    return (root, query, cb) ->
            category == null ? cb.conjunction() : cb.equal(root.get("category"), category);
  }

  public static Specification<ProductEntity> hasCreated(LocalDateTime startDate, LocalDateTime endDate) {
    return (root, query, cb) -> {
      if (startDate != null && endDate != null) {
        return cb.between(root.get("createdAt"), startDate, endDate);
      } else if (startDate != null) {
        return cb.greaterThanOrEqualTo(root.get("createdAt"), startDate);
      } else if (endDate != null) {
        return cb.lessThanOrEqualTo(root.get("createdAt"), endDate);
      } else {
        return cb.conjunction();
      }
    };
  }

  public static Specification<ProductEntity> hasActive(Boolean active) {
    return (root, query, cb) ->
            active == null ? cb.conjunction() : (active ? cb.isTrue(root.get("active")) : cb.isFalse(root.get("active")));
  }
}
