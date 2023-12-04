package com.example.labb2.controller.v1;


import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.model.Category;
import com.example.labb2.model.Place;
import com.example.labb2.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/places")
public class PlaceController {
    private final PlaceService service;
    @Autowired
    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) Optional<Long> searchId,
                                    @RequestParam(required = false) Optional<Long> category
    ) {
        if (searchId.isPresent()) {
            return ResponseEntity.ok().body(service.getPublicPlaceById(searchId.get()));
        } else if (category.isPresent()) {
            return ResponseEntity.ok().body(service.getAllPublicPlacesInCategory(category.get()));
        }
        return ResponseEntity.ok().body(service.getAllPublicPlaces());
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<?> getSpecific(@PathVariable String userId) {
        return ResponseEntity.ok().body(service.getByUserId(userId));
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Place> create(@RequestBody PlaceDto place) {
        var createdPlace = service.createPlace(place);

        URI locationURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(createdPlace.getPlaceId())
                .toUri();

        return ResponseEntity.created(locationURI).body(createdPlace);
    }

    @PatchMapping(path = "/{placeId}")
    public ResponseEntity<?> updatePlace(@PathVariable Long placeId, @RequestBody PlaceDto place) {
        return ResponseEntity.ok().body(service.updatePlace(placeId, place));
    }

    @DeleteMapping(path = "/{placeId}")
    public ResponseEntity<?> deletePlace(@PathVariable Long placeId) throws IllegalAccessException {
        service.deletePlace(placeId);
        return ResponseEntity.ok("Place with ID: " + placeId + " was successfully deleted");
    }

}
