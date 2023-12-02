package com.example.labb2.controller.v1;

import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.model.Place;
import com.example.labb2.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public List<Place> getAllPlaces(){
        return service.getAllPlaces();
    }

    @GetMapping("{id}")
    public Optional<Place> getPlace(@PathVariable long id){
        return service.getPlaceById(id);
    }
}
