package com.gplf.gusfood.domain.repository;

import com.gplf.gusfood.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
