package jpa.example.basexamp.service;

import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAll(){
        return this.teamRepository.findAll();
    }

    public Team getById(Integer id){
        return this.teamRepository.findById(id).orElse(null);
    }

    public Boolean exist(Integer id){
        return this.teamRepository.existsById(id);
    }

    public Team save(Team team){
        return this.teamRepository.save(team);
    }

    public void delete(Integer id){
        this.teamRepository.deleteById(id);
    }
}
