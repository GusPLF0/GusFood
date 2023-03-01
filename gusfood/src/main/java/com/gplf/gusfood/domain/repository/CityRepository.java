package com.gplf.gusfood.domain.repository;

import com.gplf.gusfood.domain.model.City;
import com.gplf.gusfood.domain.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
