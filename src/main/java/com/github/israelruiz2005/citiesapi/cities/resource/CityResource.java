package com.github.israelruiz2005.citiesapi.cities.resource;

import com.github.israelruiz2005.citiesapi.cities.entity.City;
import com.github.israelruiz2005.citiesapi.cities.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cities")
public class CityResource {

    private final CityRepository cityRepository;

    public CityResource(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return cityRepository.findAll(page);
    }

}
