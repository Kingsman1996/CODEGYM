package com.repo;

import com.model.application.Application;
import com.model.job.Post;
import com.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
