package com.example.labb2.service;

import com.example.labb2.dto.CategoryDto;
import com.example.labb2.dto.PlaceDto;
import com.example.labb2.service.interfaces.IPlaceService;

import java.util.List;

public class PlaceService implements IPlaceService {
    @Override
    public List<PlaceDto> getAllPublicPlaces() {
        return null;
    }

    @Override
    public PlaceDto getPublicPlace() {
        return null;
    }

    @Override
    public List<PlaceDto> getAllPublicPlacesInCategory(CategoryDto category) {
        return null;
    }

    @Override
    public List<PlaceDto> getAllPlaces() {
        return null;
    }

    @Override
    public List<PlaceDto> getPlacesInArea(int radius) {
        return null;
    }

    @Override
    public void createPlace() {

    }

    @Override
    public Boolean updatePlace() {
        return null;
    }

    @Override
    public void deletePlace() {

    }
}
