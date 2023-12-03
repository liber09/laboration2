package com.example.labb2.service;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.exception.NotFoundException;
import com.example.labb2.model.Place;
import com.example.labb2.repository.CategoryRepository;
import com.example.labb2.repository.PlaceRepository;
import com.example.labb2.service.interfaces.IPlaceService;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService implements IPlaceService {
    PlaceRepository placeRepository;
    CategoryRepository categoryRepository;


    public PlaceService(PlaceRepository placeRepository, CategoryRepository categoryRepository) {

        this.placeRepository = placeRepository;
        this.categoryRepository = categoryRepository;
    }

    public Optional<Place> getPlaceById(long id) {
        return placeRepository.findById(id);
    }

    @Override
    @PostFilter("filterObject.isPrivate == false || filterObject.userId == authentication.name")
    public List<Place> getAllPublicPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public PlaceDto getPublicPlace() {
        return null;
    }

    @Override
    public List<Place> getAllPublicPlacesInCategory(Long categoryId) {
        var category = categoryRepository.findById(categoryId);

        if (category.isEmpty()) {
            throw new NotFoundException("Category not found.");
        }

        return placeRepository.findAllByCategory_Name(category.get().getName());

    }

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
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
