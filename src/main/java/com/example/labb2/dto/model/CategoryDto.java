package com.example.labb2.dto.model;

import com.example.labb2.model.Place;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Accessors(chain = true)
//@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)


public record CategoryDto(Long categoryId,
                          String name,
                          String symbol,
                          String description,
                          Set<Place> locations,
                          LocalDateTime createdAt,
                          LocalDateTime updatedAt)
        implements Serializable {
}
