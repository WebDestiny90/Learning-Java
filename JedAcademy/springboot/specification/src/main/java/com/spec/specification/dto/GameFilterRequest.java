package com.spec.specification.dto;

import lombok.Data;

@Data
public class GameFilterRequest {
    private String title;
    private String genre;
    private Double minPrice;
    private Double maxPrice;
    private Integer releaseYear;
}
