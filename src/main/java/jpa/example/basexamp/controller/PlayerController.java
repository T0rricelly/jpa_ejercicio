package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.Player;
import jpa.example.basexamp.service.PlayerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerServiceImp playerService;

    public PlayerController(PlayerServiceImp playerService) {
        this.playerService = playerService;
    }

    // Obtener todos los players
    @GetMapping
    public ResponseEntity<List<Player>> getAll() {
        return ResponseEntity.ok(this.playerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (this.playerService.exist(id)) {
            return ResponseEntity.ok(this.playerService.findById(id));
        }
        return ResponseEntity.badRequest().body("No se encontro");
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player) {
        if (player.getId() == null || !this.playerService.exist(player.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.playerService.save(player));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Player player) {
        if (player.getId() != null && this.playerService.exist(player.getId())) {
            this.playerService.save(player);
            return ResponseEntity.ok("Se actualizo correctamente");
        }
        return ResponseEntity.badRequest().body("No se encontro");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        if (this.playerService.exist(id)) {
            this.playerService.delete(id);
            return ResponseEntity.ok("Se elimino correctamente");
        }
        return ResponseEntity.badRequest().body("No se encontro");
    }

}
