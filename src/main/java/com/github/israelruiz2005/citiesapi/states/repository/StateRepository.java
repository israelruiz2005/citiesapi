package com.github.israelruiz2005.citiesapi.states.repository;

import com.github.israelruiz2005.citiesapi.states.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
