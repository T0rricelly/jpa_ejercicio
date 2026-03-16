package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.service.dto.TeamDto;

import java.util.List;

public interface TeamMapper {

    Team toTeam(TeamDto teamDto);

    TeamDto toTeamDto(Team team);

    List<TeamDto> toTeamDtos(List<Team> teams);

    void updateTeam(Team team, TeamDto teamDto);
}
