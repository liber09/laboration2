package com.example.labb2.dto.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public record CategoryDto(Long categoryId,
                          String name,
                          String symbol,
                          String description,
                          //Set<Place> locations,
                          LocalDateTime createdAt,
                          LocalDateTime updatedAt)
        implements Serializable {
}
