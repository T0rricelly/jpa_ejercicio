package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.service.StadiumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public ResponseEntity<List<Stadium>> getAll(){
        return ResponseEntity.ok(this.stadiumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        if (this.stadiumService.exist(id)){
            return ResponseEntity.ok(this.stadiumService.getById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro nada en la base de datos");
    }

    @PostMapping
    public ResponseEntity<Stadium> save(@RequestBody Stadium stadium){
        if (stadium.getId() == null || this.stadiumService.exist(stadium.getId())){
            return ResponseEntity.status(HttpStatus.CREATED).body(this.stadiumService.save(stadium));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Stadium stadium){
        if (this.stadiumService.exist(stadium.getId())){
            return ResponseEntity.ok(this.stadiumService.save(stadium));
        }
        return ResponseEntity.badRequest().body("No se encontro el " + stadium.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        if (this.stadiumService.exist(id)){
            this.stadiumService.delete(id);
            return ResponseEntity.ok("El id " + id + " fue eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro");
    }

}
