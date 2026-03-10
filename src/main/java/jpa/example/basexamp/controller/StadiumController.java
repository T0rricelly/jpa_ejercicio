package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.service.StadiumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
