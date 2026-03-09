package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.Player;
import jpa.example.basexamp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // Obtener todos los players
    @GetMapping
    public ResponseEntity<List<Player>> getAll(){
        return ResponseEntity.ok(this.playerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Integer id){
        return ResponseEntity.ok(this.playerService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<Player> save(@RequestBody Player player){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.playerService.save(player));
    }
}
