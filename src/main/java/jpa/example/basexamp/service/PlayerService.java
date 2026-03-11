package jpa.example.basexamp.service;

import jpa.example.basexamp.entity.Player;
import jpa.example.basexamp.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    // Inyeccion de PlayerRepsoitory
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Obtener todos los player
    public List<Player> getAll(){
        return this.playerRepository.findAll();
    }

    // Obtener Jugador por id
    public Player findById(Integer id){
        return this.playerRepository.findById(id).orElse(null);
    }

    public Boolean exist(Integer id){
        return this.playerRepository.existsById(id);
    }

    // Crear un player
    public Player save(Player player){
        return this.playerRepository.save(player);
    }

    public void delete(Integer id){
        this.playerRepository.deleteById(id);
    }
}
