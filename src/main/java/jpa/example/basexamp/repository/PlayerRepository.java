package jpa.example.basexamp.repository;

import jpa.example.basexamp.entity.Player;
import org.springframework.data.repository.ListCrudRepository;

public interface PlayerRepository extends ListCrudRepository<Player,Integer> {
}
