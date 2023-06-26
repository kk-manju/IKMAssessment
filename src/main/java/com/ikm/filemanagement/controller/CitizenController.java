package com.ikm.filemanagement.controller;


import com.ikm.filemanagement.model.CitizenData;
import com.ikm.filemanagement.repository.CitizenRepository;
import com.ikm.filemanagement.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CitizenController {
    CitizenRepository citizenRepository;
    CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @PostMapping(value = "/citizen")
    public ResponseEntity<String> createCitizen(@Valid @RequestBody  CitizenData citizenData) {
        if (citizenData.getName() == null){
            return new ResponseEntity("Name must not be Blank", HttpStatus.BAD_REQUEST);
        }
        if (citizenData.getAddress() == null){
            return new ResponseEntity("Name must not be Blank",HttpStatus.BAD_REQUEST);
        }

        else{
            CitizenData savedCitizen = citizenRepository.save(citizenData);
            int id = savedCitizen.getId();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Location", "/api/v1/citizen/" + id)
                    .body("Citizen created");

        }
    }
}
