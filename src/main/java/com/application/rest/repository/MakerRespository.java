package com.application.rest.repository;

import com.application.rest.entities.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRespository extends JpaRepository<Maker, Long> {
}
