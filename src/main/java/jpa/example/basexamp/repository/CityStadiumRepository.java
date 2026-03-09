package jpa.example.basexamp.repository;

import jpa.example.basexamp.entity.CityStadium;
import org.springframework.data.repository.ListCrudRepository;

public interface CityStadiumRepository extends ListCrudRepository<CityStadium, Integer> {
}
