package com.user.page.pagination.dao.repository;

import com.user.page.pagination.dao.entity.UserClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<UserClientEntity, Long>, JpaSpecificationExecutor<UserClientEntity> {
}
