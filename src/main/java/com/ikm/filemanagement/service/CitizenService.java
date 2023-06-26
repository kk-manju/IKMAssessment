package com.ikm.filemanagement.service;

import com.ikm.filemanagement.model.CitizenData;
import com.ikm.filemanagement.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService implements CitizenInterface {
    CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Override
    public CitizenData save(CitizenData citizenData) {
        return citizenRepository.save(citizenData);
    }
}