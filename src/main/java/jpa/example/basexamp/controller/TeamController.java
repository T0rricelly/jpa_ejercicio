package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.service.TeamServiceImp;
import jpa.example.basexamp.service.dto.TeamDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private final TeamServiceImp teamService;

    public TeamController(TeamServiceImp teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAll(){
        return ResponseEntity.ok(this.teamService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (this.teamService.exist(id)) {
            return ResponseEntity.ok(this.teamService.getById(id));
        }
        return ResponseEntity.badRequest().body("No se encontro");
    }

    @PostMapping
    public ResponseEntity<TeamDto> save(@RequestBody TeamDto teamDto) {
        if (teamDto.getId() == null || !this.teamService.exist(teamDto.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.teamService.save(teamDto));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TeamDto teamDto) {
        if (teamDto.getId() != null && this.teamService.exist(id)) {
            return ResponseEntity.ok().body(this.teamService.update(id, teamDto));
        }
        return ResponseEntity.badRequest().body("No se ha encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeamDto> deleteById(@PathVariable Integer id) {
        if (this.teamService.exist(id)) {
            return ResponseEntity.ok().body(this.teamService.delete(id));
        }
        return ResponseEntity.badRequest().build();
    }
}
