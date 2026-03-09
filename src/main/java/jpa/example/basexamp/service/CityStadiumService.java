package jpa.example.basexamp.service;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.repository.CityStadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityStadiumService {
    // Inyeccion de CityStadiumRepository
    private final CityStadiumRepository cityStadiumRepository;

    public CityStadiumService(CityStadiumRepository cityStadiumRepository) {
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
}
