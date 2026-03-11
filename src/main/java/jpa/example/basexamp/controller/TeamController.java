package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAll() {
        return ResponseEntity.ok(this.teamService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getById(@PathVariable Integer id) {
        if (this.teamService.exist(id)) {
            return ResponseEntity.ok(this.teamService.getById(id));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Team> save(@RequestBody Team team) {
        if (team.getId() == null || !this.teamService.exist(team.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.teamService.save(team));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Team team) {
        if (team.getId() != null && this.teamService.exist(team.getId())) {
            this.teamService.save(team);
            return ResponseEntity.ok().body("Se ha actualizado correctamente");
        }
        return ResponseEntity.badRequest().body("No se ha encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        if (this.teamService.exist(id)) {
            this.teamService.delete(id);
            return ResponseEntity.ok().body("Se ha eliminado correctamente");
        }
        return ResponseEntity.badRequest().body("No se ha encontrado");
    }
}
