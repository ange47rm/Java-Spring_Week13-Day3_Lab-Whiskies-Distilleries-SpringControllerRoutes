package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(int year);

    List<Whisky> findWhiskyByAge(int age);

    List<Whisky> findWhiskyByDistilleryName(String distilleryName);

    List<Whisky> findWhiskyByDistilleryAndAge(String distilleryName, int age);


}
