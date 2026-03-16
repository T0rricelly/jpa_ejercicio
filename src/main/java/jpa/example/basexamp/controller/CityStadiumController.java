package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.service.CityStadiumServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityStadiumController {
    private final CityStadiumServiceImp cityStadiumService;

    public CityStadiumController(CityStadiumServiceImp cityStadiumService) {
        this.cityStadiumService = cityStadiumService;
    }

    @GetMapping
    public ResponseEntity<List<CityStadium>> getAll() {
        return ResponseEntity.ok(this.cityStadiumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityStadium> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.cityStadiumService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CityStadium> save(@RequestBody CityStadium cityStadium) {
        if (cityStadium.getId() == null || !this.cityStadiumService.exist(cityStadium.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.cityStadiumService.create(cityStadium));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<CityStadium> update(@RequestBody CityStadium cityStadium){
        if (cityStadium.getId() != null && this.cityStadiumService.exist(cityStadium.getId())){
            return ResponseEntity.ok(this.cityStadiumService.create(cityStadium));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        if (this.cityStadiumService.exist(id)){
            this.cityStadiumService.delete(id);
            return ResponseEntity.ok().body("La ciudad con el id " + id + " fue eliminada");
        }
        return ResponseEntity.badRequest().body("No se ha encontrado");
    }


}
