package com.example.labb2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name= "category")
public class Category {
    @Id
    @Column(name = "categoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name="name", unique = true)
    @Size(min = 2, max = 255)
    @NotNull
    @JsonProperty("name")
    private String name;

    @Column(name="symbol")
    @Size(max = 255)
    @JsonProperty("symbol")
    private String symbol;

    @Column(name="description")
    @Size(max = 255)
    @JsonProperty("description")
    private String description;

    @CreationTimestamp
    @Column(name="createdAt")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("changedAt")
    @UpdateTimestamp
    @Column(name="changedAt")
    private LocalDateTime changedAt;
}
