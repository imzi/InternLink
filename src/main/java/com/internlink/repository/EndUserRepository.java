package com.internlink.repository;

import com.internlink.model.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, UUID> {
}
