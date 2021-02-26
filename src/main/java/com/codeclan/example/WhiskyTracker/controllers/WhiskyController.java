package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping(value= "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="age", required = false) Integer age,
            @RequestParam(name="distillery", required = false) String distillery)   {

            // if YEAR is provided, return whiskies by year
        if (year != null){
            return new ResponseEntity(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);

            // if DISTILLERY and AGE are provided, return whiskies in a certain distillery of a certain age
        } else if (distillery != null && age != null) {
            List<Whisky> foundWhiskies = new ArrayList<Whisky>();
            List<Whisky> foundWhiskiesByDistillery = whiskyRepository.findWhiskyByDistilleryName(distillery);
            for (Whisky whisky : foundWhiskiesByDistillery){
                if (whisky.getAge() == age){
                    foundWhiskies.add(whisky);}
            }
            return new ResponseEntity<>(foundWhiskies, HttpStatus.OK);
            // if only AGE is provided, return whiskies by age
        } else if (age != null) {
            return new ResponseEntity(whiskyRepository.findWhiskyByAge(age), HttpStatus.OK);
            // if only DISTILLERY is provided, return whiskies by distillery
        } else if (distillery != null) {
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryName(distillery), HttpStatus.OK);
            // if no parameters are provided, return ALL whiskies
        } else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }}









    @GetMapping(value="/whiskies/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }


}
