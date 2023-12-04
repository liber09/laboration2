package com.example.labb2.service.interfaces;

import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.model.Place;

import java.util.List;
import java.util.Optional;

public interface IPlaceService {

    Optional<Place> getPlaceById(long id);
    List<Place> getAllPublicPlaces ();
    Optional<Place> getPublicPlaceById (Long placeId);
    List<Place> getAllPublicPlacesInCategory(Long categoryId);
    List<Place> getAllPlaces();
    List<Place> getPlacesInArea(int radius);

    void createPlace();
    Boolean updatePlace();

    void deletePlace();
}
