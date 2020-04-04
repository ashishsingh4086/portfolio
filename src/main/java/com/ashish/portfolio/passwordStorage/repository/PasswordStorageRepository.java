package com.ashish.portfolio.passwordStorage.repository;

import com.ashish.portfolio.passwordStorage.model.PasswordStorage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordStorageRepository extends JpaRepository<PasswordStorage, Integer> {
    PasswordStorage findById(Long id);
}
