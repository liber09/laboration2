package com.example.labb2.dto.model;

import com.example.labb2.model.Place;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public record CategoryDto(Long categoryId,
                          String name,
                          String symbol,
                          String description,
                          LocalDateTime createdAt,
                          LocalDateTime changedAt)
        implements Serializable {
}
