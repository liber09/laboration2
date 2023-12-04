package com.example.labb2.dto.mapper;

import com.example.labb2.dto.model.PlaceDto;
import com.example.labb2.model.Place;

public class PlaceMapper {
    public static PlaceDto toPlaceDto(Place place){
        return new PlaceDto()
                .setPlaceId(place.getPlaceId())
                .setCategory(place.getCategory())
                .setCoordinate(place.getCoordinate())
                .setIsPrivate(place.getIsPrivate())
                .setName(place.getName())
                .setCreated(place.getCreated())
                .setDescription(place.getDescription())
                .setStatus(place.getStatus());
    }
}
