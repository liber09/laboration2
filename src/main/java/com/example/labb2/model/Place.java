package com.example.labb2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name= "place")

public class Place {
    @Id
    @Column(name = "placeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;

    @Column(name="name")
    private String name;

    @Column(name="categoryId")
    private String categoryId;


}
