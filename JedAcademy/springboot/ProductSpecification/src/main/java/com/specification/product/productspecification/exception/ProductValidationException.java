package com.specification.product.productspecification.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class ProductValidationException extends RuntimeException {
    private final Map<String, String> errors;

    public ProductValidationException(Map<String, String> errors) {
        super("Product validation failed");
        this.errors = errors;
    }

}
