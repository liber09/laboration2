package com.example.labb2.service;

import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.exception.NotFoundException;
import com.example.labb2.model.Coordinates;
import com.example.labb2.model.Place;
import com.example.labb2.repository.CategoryRepository;
import com.example.labb2.repository.PlaceRepository;
import com.example.labb2.service.interfaces.IPlaceService;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

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
    public Place createPlace(PlaceDto place) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();

        var newPlace = verify(place.coordinate());

        var category = categoryRepository.findById(place.categoryId());

        if (category.isEmpty())
            throw new IllegalArgumentException("Category does not exist");

        newPlace.setCategory(category.get());
        newPlace.setName(place.name());
        newPlace.setDescription(place.description());
        newPlace.setIsPrivate(place.isPrivate());
        newPlace.setUserId(userName);
        newPlace.setCreated(LocalDateTime.now().toLocalDate());
        newPlace.setLastUpdated(newPlace.getCreated());

        return placeRepository.save(newPlace);
    }

    @Override
    public Boolean updatePlace() {
        return null;
    }

    @Override
    public void deletePlace() {

    }

    public Place verify(Coordinates position) {
        var place = new Place();

        if (position.lat() < -90 || position.lat() > 90 || position.lon() < -180 || position.lon() > 180) {
            throw new IllegalArgumentException("Invalid latitude or longitude values");
        }
        var longLat = Geometries.mkPoint(new G2D(position.lon(), position.lat()), WGS84);

        place.setCoordinate(longLat);
        return place;
    }
}
