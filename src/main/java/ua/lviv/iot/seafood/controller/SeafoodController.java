package ua.lviv.iot.seafood.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.seafood.business.SeafoodService;
import ua.lviv.iot.seafood.model.Seafood;

@RequestMapping("/seafood")
@RestController
public class SeafoodController {

    private static AtomicInteger idCounter = new AtomicInteger();

    @Autowired
    private SeafoodService seafoodService;

    @GetMapping
    public List<Seafood> getSeafood() {
        return new LinkedList<Seafood>(seafoodService.findSeafood());
    }

    @GetMapping("/{id}")
    public Seafood getPieceOfSeafood(final @PathVariable("id") Integer seafoodId) {
        return seafoodService.findPieceOfSeafood(seafoodId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putSeafood(final @PathVariable("id") Integer seafoodId,
            final @RequestBody Seafood seafood) {
        seafood.setId(seafoodId);
        if (seafoodService.checkForSeafoodExistence(seafoodId)) {
            return ResponseEntity.ok(seafoodService.updateSeafood(seafoodId, seafood));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<Seafood> deleteSeafood(final @PathVariable("id") Integer seafoodId) {
        if (seafoodService.checkForSeafoodExistence(seafoodId)) {
            seafoodService.deleteSeafood(seafoodId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Seafood createSeafood(final @RequestBody Seafood seafood) {
        seafood.setId(idCounter.incrementAndGet());
        seafoodService.createSeafood(seafood);
        return seafood;
    }
}