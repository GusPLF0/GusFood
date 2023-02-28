package com.gplf.gusfood.domain.repository;

import com.gplf.gusfood.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
