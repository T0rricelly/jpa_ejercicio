package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Player;
import jpa.example.basexamp.service.dto.PlayerDto;

import java.util.ArrayList;
import java.util.List;

public class PlayerMapperImp implements PlayerMapper{
    @Override
    public Player toPlayer(PlayerDto playerDto) {
        if (playerDto == null){
            return null;
        }

        Player player = new Player();
        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setLastName(playerDto.getLastName());
        player.setAge(playerDto.getAge());
        player.setNationality(playerDto.getNationality());

        return player;
    }

    @Override
    public PlayerDto toPlayerDto(Player player) {
        if (player == null){
            return null;
        }

        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setName(player.getName());
        playerDto.setLastName(player.getLastName());
        playerDto.setAge(player.getAge());
        playerDto.setNationality(player.getNationality());

        return playerDto;

    }

    @Override
    public List<PlayerDto> toPlayerDtos(List<Player> players) {
        if (players == null){
            return null;
        }

        List<PlayerDto> listDto = new ArrayList<>(players.size());
        for (Player player : players){
            listDto.add(toPlayerDto(player));
        }
        return listDto;
    }

    @Override
    public void updatePlayer(Player player, PlayerDto playerDto) {
        if (playerDto == null) return;

        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setLastName(playerDto.getLastName());
        player.setAge(playerDto.getAge());
        player.setNationality(playerDto.getNationality());

    }
}
