package jpa.example.basexamp.service;

import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.repository.TeamRepository;
import jpa.example.basexamp.service.dto.TeamDto;
import jpa.example.basexamp.service.mapper.TeamMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImp implements TeamService{
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamServiceImp(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public List<TeamDto> getAll(){
        return this.teamMapper.toTeamDtos(this.teamRepository.findAll());
    }

    public TeamDto getById(Integer id) {
        return this.teamMapper.toTeamDto(this.teamRepository.findById(id).orElse(null));
    }

    public Boolean exist(Integer id){
        return this.teamRepository.existsById(id);
    }

    public TeamDto save(TeamDto teamDto){
        Team team = this.teamMapper.toTeam(teamDto);
        return this.teamMapper.toTeamDto(this.teamRepository.save(team));
    }

    public TeamDto update(Integer id, TeamDto teamDto) {
        Team team = this.teamRepository.findById(id).orElse(null);
        this.teamMapper.updateTeam(team,teamDto);
        return this.teamMapper.toTeamDto(this.teamRepository.save(team));
    }

    public TeamDto delete(Integer id){
        Team team = this.teamRepository.findById(id).orElse(null);
        TeamDto teamDto = this.teamMapper.toTeamDto(team);
        this.teamRepository.deleteById(id);
        return teamDto;
    }
}
