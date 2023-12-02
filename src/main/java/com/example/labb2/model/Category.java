package com.example.labb2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name="name")
    @Size(max = 255)
    private String name;

    @Column(name="name")
    @Size(max = 255)
    private String symbol;

    @Column(name="description")
    @Size(max = 255)
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Place> locations = new LinkedHashSet<>();
}
