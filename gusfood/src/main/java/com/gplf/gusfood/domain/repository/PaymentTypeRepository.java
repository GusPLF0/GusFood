package com.gplf.gusfood.domain.repository;

import com.gplf.gusfood.domain.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
