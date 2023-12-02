package com.example.labb2.repository;

import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.model.Place;
import org.springframework.data.repository.ListCrudRepository;

public interface PlaceRepository extends ListCrudRepository<Place, Long> {
}
