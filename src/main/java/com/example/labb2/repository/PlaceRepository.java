package com.example.labb2.repository;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.labb2.model.Place;
import java.util.List;

public interface PlaceRepository extends ListCrudRepository<Place, Long> {
    List<Place> getPlacesByUserId(String userId);
    List<Place> findAllByCategory_Name(String category);

    /*
    @Query(value = """
            SELECT * FROM place
            WHERE ST_Within(coordinate, ST_GeomFromText(:polygon, 4326))
                """, nativeQuery = true)
    List<Place> filterWithinPolygon(@Param("polygon") String polygon);

    @Query(value = """
            SELECT * FROM place
            WHERE ST_Distance_Sphere(coordinate, :place) < :distance
                """, nativeQuery = true)
    List<Place> filterOnDistance(@Param("place") Point<G2D> place, @Param("distance") double distance);
    */
}
