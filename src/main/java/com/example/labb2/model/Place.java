package com.example.labb2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.geo.Point;

import java.time.LocalDate;

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

    @PrimaryKeyJoinColumn(name="categoryId")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @PrimaryKeyJoinColumn(name="userId")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name="status")
    private String status;

    @Column(name="created")
    private LocalDate created;

    @Column(name="lastUpdated")
    private LocalDate lastUpdated;

    @Column(name="description")
    private String description;

    @Column(name="coordinates")
    private Point coordinates;

}
