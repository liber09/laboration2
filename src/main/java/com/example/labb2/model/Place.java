package com.example.labb2.model;

import com.example.labb2.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(max = 255)
    private String name;

    @PrimaryKeyJoinColumn(name="categoryId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @PrimaryKeyJoinColumn(name="userId")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name="isPrivate")
    private Boolean isPrivate;

    @Size(max = 255)
    @Column(name="status")
    private String status;

    @Column(name="created")
    private LocalDate created;

    @Column(name="lastUpdated")
    private LocalDate lastUpdated;

    @Column(name="description")
    @Size(max = 255)
    private String description;

    @Column(name="coordinates")
    private Point coordinates;

}
