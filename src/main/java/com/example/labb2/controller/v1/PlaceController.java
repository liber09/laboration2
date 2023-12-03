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
    public ResponseEntity<?> getAll(@RequestParam(required = false) Optional<Long> search,
                                    @RequestParam(required = false) Optional<Long> category
    ) {
        if (search.isPresent()) {
            //return ResponseEntity.ok().body(service.findPublicById(search.get()));
        } else if (category.isPresent()) {
            return ResponseEntity.ok().body(service.getAllPublicPlacesInCategory(category.get()));
        }
        return ResponseEntity.ok().body(service.getAllPublicPlaces());
    }

    @GetMapping("{id}")
    public Optional<Place> getPlace(@PathVariable long id){
        return service.getPlaceById(id);
    }
}
