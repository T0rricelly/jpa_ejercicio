package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Player;
import jpa.example.basexamp.service.dto.PlayerDto;

import java.util.List;

public interface PlayerMapper {

    // PlayerDto a Player
    Player toPlayer(PlayerDto playerDto);

    // Player a PlayerDto
    PlayerDto toPlayerDto(Player player);

    // Lista de Player a PlayerDto
    List<PlayerDto> toPlayerDtos(List<Player> players);

    // Actualizar Cliente
    void updatePlayer(Player player, PlayerDto playerDto);
}
