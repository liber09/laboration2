package com.example.labb2.service;

import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.exception.NotFoundException;
import com.example.labb2.model.Category;
import com.example.labb2.model.Coordinates;
import com.example.labb2.model.Place;
import com.example.labb2.repository.CategoryRepository;
import com.example.labb2.repository.PlaceRepository;
import com.example.labb2.service.interfaces.IPlaceService;
import org.geolatte.geom.*;
import org.geolatte.geom.builder.DSL;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.geolatte.geom.G2D;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.geolatte.geom.jts.JTS;
import com.vividsolutions.jts.geom.Geometry;

import static org.geolatte.geom.builder.DSL.g;
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
    @PostFilter("!filterObject.isPrivate || filterObject.userId == authentication.name")
    public List<Place> getAllPublicPlaces() {
        return placeRepository.findAll();
    }

    public Optional<Place> getPublicPlaceById(Long placeId) {

        return placeRepository.findById(placeId);
    }

    @Override
    @PostFilter("!filterObject.isPrivate || filterObject.userId == authentication.name")
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
        if(place.isPrivate() != null){
            newPlace.setIsPrivate(place.isPrivate());
        }
        newPlace.setUserId(userName);
        newPlace.setCreated(LocalDateTime.now().toLocalDate());
        newPlace.setLastUpdated(newPlace.getCreated());

        return placeRepository.save(newPlace);
    }

    @Override
    @PreAuthorize("#place.userId().equalsIgnoreCase(authentication.name)")
    public Place updatePlace(Long placeId, PlaceDto place) {

        Optional<Place> placeInfo = getPlaceById(placeId);

        if (placeInfo.isPresent()) {
            Place placeToUpdate = placeInfo.get();

            Optional<Category> category = categoryRepository.findById(place.categoryId());
            placeToUpdate.setCategory(category.orElseThrow(() -> new NotFoundException("Category not found")));
            placeToUpdate.setName(place.name());
            placeToUpdate.setDescription(place.description());

            return placeRepository.save(placeToUpdate);
        } else {
            throw new NotFoundException("Place with id: " + placeId + " does not exist");
        }
    }

    @Override
    public void deletePlace(Long placeId) throws IllegalAccessException {
        var placeToDelete = placeRepository.findById(placeId);
        if (placeToDelete.isEmpty()) {
            throw new NotFoundException("Place with ID: " + placeId + " does not exist");
        }

        var locationUserId = placeToDelete.get().getUserId();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = auth.getName();

        if (locationUserId.equalsIgnoreCase(currentUser)) {
            placeRepository.deleteById(placeId);

        } else {
            throw new IllegalAccessException("You can only delete your own places");
        }
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

    private Optional<Place> getPlaceById(Long placeId) {
        return placeRepository.findById(placeId);
    }

    @Override
    public List<Place> getPlacesInArea(Double latitude, Double longitude, Double radius) {
        Point<G2D> location = DSL.point(WGS84, g(longitude, latitude));
        return placeRepository.filterOnDistance(location, radius);
    }
}

