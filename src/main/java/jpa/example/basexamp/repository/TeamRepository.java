package jpa.example.basexamp.repository;

import jpa.example.basexamp.entity.Team;
import org.springframework.data.repository.ListCrudRepository;

public interface TeamRepository extends ListCrudRepository<Team, Integer> {
}
