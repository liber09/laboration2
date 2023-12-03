package com.example.labb2.service;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.model.Place;
import com.example.labb2.repository.CategoryRepository;
import com.example.labb2.repository.PlaceRepository;
import com.example.labb2.service.interfaces.IPlaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService implements IPlaceService {
    PlaceRepository repository;

    public PlaceService(PlaceRepository placeRepository) {
        this.repository = placeRepository;
    }

    public Optional<Place> getPlaceById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Place> getAllPublicPlaces() {
        return null;
    }

    @Override
    public PlaceDto getPublicPlace() {
        return null;
    }

    @Override
    public List<Place> getAllPublicPlacesInCategory(CategoryDto category) {
        return null;
    }

    @Override
    public List<Place> getAllPlaces() {
        return repository.findAll();
    }

    @Override
    public List<Place> getPlacesInArea(int radius) {
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
