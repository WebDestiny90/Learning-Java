package com.redis.book.redisbook.dto;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        Integer page,
        Integer size,
        Long totalElements,
        Integer totalPages
) {}