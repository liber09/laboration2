package com.example.labb2.controller.v1;


import com.example.labb2.model.Place;
import com.example.labb2.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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
}
