package jpa.example.basexamp.service;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.repository.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumServiceImp {
    public final StadiumRepository stadiumRepository;

    public StadiumServiceImp(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public List<Stadium> getAll(){
        return this.stadiumRepository.findAll();
    }

    public Stadium getById(Integer id){
        return this.stadiumRepository.findById(id).orElse(null);
    }

    public Stadium save(Stadium stadium){
        return this.stadiumRepository.save(stadium);
    }

    public Boolean exist(Integer id){
        return this.stadiumRepository.existsById(id);
    }

    public void delete(Integer id){
        this.stadiumRepository.deleteById(id);
    }

}
