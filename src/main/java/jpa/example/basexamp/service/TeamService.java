package jpa.example.basexamp.service;

import jpa.example.basexamp.repository.TeamRepository;
import jpa.example.basexamp.service.dto.TeamDto;

import java.util.List;

public interface TeamService {

    List<TeamDto> getAll();

    TeamDto getById(Integer id);

    TeamDto save(TeamDto teamDto);

    TeamDto update (Integer id, TeamDto teamDto);

    TeamDto delete(Integer id);
}
