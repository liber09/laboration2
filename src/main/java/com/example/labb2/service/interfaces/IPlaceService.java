package com.example.labb2.service.interfaces;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.dto.model.PlaceDto;
import java.util.List;

public interface IPlaceService {

    List<PlaceDto> getAllPublicPlaces ();
    PlaceDto getPublicPlace ();
    List<PlaceDto> getAllPublicPlacesInCategory(CategoryDto category);
    List<PlaceDto> getAllPlaces();
    List<PlaceDto> getPlacesInArea(int radius);

    void createPlace();
    Boolean updatePlace();

    void deletePlace();
}
