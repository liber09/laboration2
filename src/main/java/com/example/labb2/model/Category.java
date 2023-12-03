package com.example.labb2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private String name;

    @Column(name="symbol")
    @Size(max = 255)
    private String symbol;

    @Column(name="description")
    @Size(max = 255)
    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime changedAt;

    @OneToMany(mappedBy = "category")
    private Set<Place> locations = new LinkedHashSet<>();

    public Long getId() {
        return categoryId;
    }
}
