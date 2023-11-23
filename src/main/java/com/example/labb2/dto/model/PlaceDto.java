package com.example.labb2.dto.model;

import com.example.labb2.model.Category;
import com.example.labb2.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.geo.Point;

import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDto {
    private Long placeId;
    private String name;
    private Category category;
    private User user;
    private String status;
    private LocalDate created;
    private LocalDate lastUpdated;
    private String description;
    private Point coordinates;
}
