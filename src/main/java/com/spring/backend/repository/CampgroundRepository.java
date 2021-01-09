package com.spring.backend.repository;

import com.spring.backend.entity.Campground;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampgroundRepository extends JpaRepository<Campground,Long> {
}
