package com.otpcode.otpcode.dao.repository;

import com.otpcode.otpcode.dao.entity.OtpAttemptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpAttemptRepository extends JpaRepository<OtpAttemptEntity, Long> {
  Optional<OtpAttemptEntity> findByPhoneNumber(String phoneNumber);
}
