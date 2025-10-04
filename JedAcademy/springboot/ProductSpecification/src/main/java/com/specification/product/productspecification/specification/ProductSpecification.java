package com.specification.product.productspecification.specification;

import com.specification.product.productspecification.dao.entity.ProductEntity;
import com.specification.product.productspecification.dto.ProductFilterDto;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductSpecification {

  public static Specification<ProductEntity> hasTitle(String title) {
    return (root, query, cb) ->
            (title == null || title.isBlank()) ? cb.conjunction() :
                    cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
  }

  public static Specification<ProductEntity> hasPriceGreater(BigDecimal priceMin) {
    return (root, query, cb) ->
            priceMin == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("price"), priceMin);
  }

  public static Specification<ProductEntity> hasPriceLess(BigDecimal priceMax) {
    return (root, query, cb) ->
            priceMax == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get("price"), priceMax);
  }

  public static Specification<ProductEntity> hasStockGreater(Integer stockMin) {
    return (root, query, cb) ->
            stockMin == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("stock"), stockMin);
  }

  public static Specification<ProductEntity> hasStockLess(Integer stockMax) {
    return (root, query, cb) ->
            stockMax == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get("stock"), stockMax);
  }

  public static Specification<ProductEntity> hasBrand(String brand) {
    return (root, query, cb) ->
            (brand == null || brand.isBlank()) ? cb.conjunction() :
                    cb.equal(cb.lower(root.get("brand")), brand.toLowerCase());
  }

  public static Specification<ProductEntity> hasCategory(String category) {
    return (root, query, cb) ->
            (category == null || category.isBlank()) ? cb.conjunction() :
                    cb.equal(cb.lower(root.get("category")), category.toLowerCase());
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

  public static Specification<ProductEntity> hasRatingGreater(Double ratingMin) {
    return (root, query, cb) ->
            ratingMin == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("rating"), ratingMin);
  }

  public static Specification<ProductEntity> hasRatingLess(Double ratingMax) {
    return (root, query, cb) ->
            ratingMax == null ? cb.conjunction() : cb.lessThanOrEqualTo(root.get("rating"), ratingMax);
  }

  public static Specification<ProductEntity> filter(ProductFilterDto filterDto) {
    return Specification.allOf(
            hasTitle(filterDto.getTitle()),
            hasPriceGreater(filterDto.getPriceMin()),
            hasPriceLess(filterDto.getPriceMax()),
            hasStockGreater(filterDto.getStockMin()),
            hasStockLess(filterDto.getStockMax()),
            hasBrand(filterDto.getBrand()),
            hasCategory(filterDto.getCategory()),
            hasCreated(filterDto.getCreatedStart(), filterDto.getCreatedEnd()),
            hasActive(filterDto.getActive()),
            hasRatingGreater(filterDto.getRatingMin()),
            hasRatingLess(filterDto.getRatingMax())
    );
  }
}
