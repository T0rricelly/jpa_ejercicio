package jpa.example.basexamp.service;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.repository.CityStadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityStadiumServiceImp {
    // Inyeccion de CityStadiumRepository
    private final CityStadiumRepository cityStadiumRepository;

    public CityStadiumServiceImp(CityStadiumRepository cityStadiumRepository) {
        this.cityStadiumRepository = cityStadiumRepository;
    }

    // Obtener todas las ciudades
        public List<CityStadium> getAll(){
        return this.cityStadiumRepository.findAll();
    }

    // Obtener ciudad por id
    public CityStadium getById(Integer id){
        return this.cityStadiumRepository.findById(id).orElse(null);
    }

    // Crear una city
    public CityStadium create(CityStadium cityStadium){
        return this.cityStadiumRepository.save(cityStadium);
    }

    public Boolean exist(Integer id){
        return this.cityStadiumRepository.existsById(id);
    }

    public void delete(Integer id){
        this.cityStadiumRepository.deleteById(id);
    }
}
