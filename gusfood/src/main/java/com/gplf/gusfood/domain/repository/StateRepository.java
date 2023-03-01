package com.gplf.gusfood.domain.repository;

import com.gplf.gusfood.domain.model.Kitchen;
import com.gplf.gusfood.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
