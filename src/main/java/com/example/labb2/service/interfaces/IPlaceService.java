package com.example.labb2.service.interfaces;

import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.model.Place;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IPlaceService {

    Optional<Place> getPlaceById(long id);
    List<Place> getAllPublicPlaces ();
    Optional<Place> getPublicPlaceById (Long placeId);
    List<Place> getAllPublicPlacesInCategory(Long categoryId);
    List<Place> getAllPlaces();
    List<Place> getPlacesInArea(int radius);

    Place createPlace(PlaceDto place);
    Place updatePlace(Long placeId, PlaceDto place);

    void deletePlace(Long placeId) throws IllegalAccessException;
}
