package jpa.example.basexamp.service;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.repository.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService {
    public final StadiumRepository stadiumRepository;

    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public List<Stadium> getAll(){
        return this.stadiumRepository.findAll();
    }

}
