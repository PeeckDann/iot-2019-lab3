package ua.lviv.iot.seafood.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.seafood.model.Seafood;

@RequestMapping("/seafood")
@RestController
public class SeafoodController {

    private static Map<Integer, Seafood> seafoodStorage = new HashMap<>();

    private static AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<Seafood> getSeafood() {
        return new LinkedList<Seafood>(seafoodStorage.values());
    }

    @GetMapping("/{id}")
    public Seafood getPieceOfSeafood(final @PathVariable("id") Integer seafoodId) {
        return seafoodStorage.get(seafoodId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> putSeafood(final @PathVariable("id") Integer seafoodId,
            final @RequestBody Seafood seafood) {
        seafood.setId(seafoodId);
        if (seafoodStorage.containsKey(seafoodId)) {
            return ResponseEntity.ok(seafoodStorage.put(seafoodId, seafood));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<Seafood> deleteSeafood(final @PathVariable("id") Integer seafoodId) {
        HttpStatus status = seafoodStorage.remove(seafoodId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Seafood createSeafood(final @RequestBody Seafood seafood) {
        seafood.setId(idCounter.incrementAndGet());
        seafoodStorage.put(seafood.getId(), seafood);
        return seafood;
    }
}