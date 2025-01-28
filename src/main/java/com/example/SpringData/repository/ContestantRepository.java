package com.example.SpringData.repository;

import com.example.SpringData.model.Contestant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestantRepository extends JpaRepository<Contestant, Integer> {

}
