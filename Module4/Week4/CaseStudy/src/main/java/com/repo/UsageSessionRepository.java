package com.repo;

import com.model.UsageSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageSessionRepository extends JpaRepository<UsageSession, Long> {
}
