package com.github.israelruiz2005.citiesapi.country.repository;

import com.github.israelruiz2005.citiesapi.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
