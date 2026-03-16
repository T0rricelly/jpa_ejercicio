package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.service.dto.TeamDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamMapperImp implements TeamMapper{
    @Override
    public Team toTeam(TeamDto teamDto) {
        if (teamDto == null){
            return null;
        }

        Team team = new Team();
        team.setId(teamDto.getId());
        team.setNameTeam(teamDto.getNameTeam());
        return team;
    }

    @Override
    public TeamDto toTeamDto(Team team) {
        if (team == null){
            return null;
        }

        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setNameTeam(team.getNameTeam());

        return teamDto;
    }

    @Override
    public List<TeamDto> toTeamDtos(List<Team> teams) {
        if (teams == null){
            return null;
        }
        List<TeamDto> listDto = new ArrayList<>(teams.size());
        for (Team team: teams){
            listDto.add(toTeamDto(team));
        }

        return listDto;
    }

    @Override
    public void updateTeam(Team team, TeamDto teamDto) {
        if (teamDto == null) return;

        team.setId(teamDto.getId());
        team.setNameTeam(teamDto.getNameTeam());

    }
}
