package com.example.labb2.dto.model;

import com.example.labb2.model.Category;
import com.example.labb2.model.Coordinates;
import java.io.Serializable;
import java.time.LocalDateTime;

public record PlaceDto(
    Long placeId,
    String name,
    Long categoryId,
    String userId,
    Boolean isPrivate,
    String status,
    LocalDateTime created,
    LocalDateTime lastUpdated,
    String description,
    Coordinates coordinate)
        implements Serializable {
}
