package jpa.example.basexamp.repository;

import jpa.example.basexamp.entity.Stadium;
import org.springframework.data.repository.ListCrudRepository;

public interface StadiumRepository extends ListCrudRepository<Stadium,Integer> {
}
