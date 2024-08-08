package com.humber.finalProjGV.controllers;

import com.humber.finalProjGV.models.Haircut;
import com.humber.finalProjGV.services.HaircutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/haircuts/api")
public class HaircutController {

    private final HaircutService haircutService;

    //constructor injection
    public HaircutController(HaircutService haircutService) {
        this.haircutService = haircutService;
    }

    //get all haircuts
    @GetMapping("/allCuts")
    public ResponseEntity<List<Haircut>> getAllHaircuts() {
        return ResponseEntity.ok(haircutService.getAllHaircuts());
    }

    //add haircut
    @PostMapping("/allCuts")
    public ResponseEntity<String> addHaircut(@RequestBody Haircut haircut) {
        haircutService.addHaircut(haircut);
        return ResponseEntity.ok("Haircut added");
    }

    @PutMapping("/allCuts/{id}")
    public ResponseEntity<Haircut> updateHaircut(@PathVariable int id, @RequestBody Haircut haircut) {
        try {
            haircutService.updateHaircut(id, haircut);
            return ResponseEntity.ok(haircut);

        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/allCuts/{id}")
    public ResponseEntity<String> deleteHaircut(@PathVariable int id) {
        try {
            haircutService.deleteHaircut(id);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok("Haircut deleted");
    }
    @GetMapping("/message")
    public String getMessage() {
        return "{\"message\": \"Welcome, admin!\"}";
    }


}
