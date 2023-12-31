package com.example.labb2.model;

import com.example.labb2.util.PointSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(name = "userId")
    private String userId;

    @Column(name="isPrivate")
    private Boolean isPrivate = false;

    @Column(name="created")
    private LocalDate created;

    @Column(name="lastUpdated")
    private LocalDate lastUpdated;

    @Column(name="description")
    @Size(max = 255)
    private String description;

    @JsonSerialize(using = PointSerializer.class)
    private Point<G2D> coordinate;



}
