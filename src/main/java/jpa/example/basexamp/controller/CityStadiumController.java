package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.service.CityStadiumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityStadiumController {
    private final CityStadiumService cityStadiumService;

    public CityStadiumController(CityStadiumService cityStadiumService) {
        this.cityStadiumService = cityStadiumService;
    }

    @GetMapping
    public ResponseEntity<List<CityStadium>> getAll(){
        return ResponseEntity.ok(this.cityStadiumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityStadium> findById(@PathVariable Integer id){
        return ResponseEntity.ok(this.cityStadiumService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<CityStadium> save(@RequestBody CityStadium cityStadium){
        return ResponseEntity.ok(this.cityStadiumService.create(cityStadium));
    }
}
