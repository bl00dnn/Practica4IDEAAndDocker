package com.example.praktika3.repository;

import com.example.praktika3.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Integer> {
    List<PeopleEntity> findByGender(String name);

    List<PeopleEntity> findByAgeGreaterThan(int age);
}
