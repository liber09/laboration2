package com.example.labb2.service;

import com.example.labb2.exception.NotFoundException;
import com.example.labb2.model.Place;
import com.example.labb2.repository.CategoryRepository;
import com.example.labb2.repository.PlaceRepository;
import com.example.labb2.service.interfaces.IPlaceService;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
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

    public Optional<Place> getPublicPlaceById(Long placeId) {
        return placeRepository.findById(placeId);
    }

    @Override
    @PostFilter("filterObject.isPrivate == false || filterObject.userId == authentication.name")
    public List<Place> getAllPublicPlacesInCategory(Long categoryId) {
        var category = categoryRepository.findById(categoryId);

        if (category.isEmpty()) {
            throw new NotFoundException("Category not found.");
        }
        return placeRepository.findAllByCategory_Name(category.get().getName());
    }

    @PreAuthorize("#userId.equalsIgnoreCase(authentication.name)")
    public List<Place> getByUserId(String userId) {
        return placeRepository.getPlacesByUserId(userId);
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
