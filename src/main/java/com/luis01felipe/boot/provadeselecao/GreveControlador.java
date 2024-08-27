package com.luis01felipe.boot.provadeselecao;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/greve")
public class GreveControlador {
    private final GreveServico greveService;

    @GetMapping
    public ResponseEntity<List<Greve>> getAllGreve() {
        List<Greve> greves = greveService.getAllGreves();

        if (greves.isEmpty()) {
            // Retorna 204 No Content se a lista estiver vazia
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // Retorna 200 OK com a lista de greves
            return new ResponseEntity<>(greves, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greve> getGreveById(@PathVariable Long id) {
        return greveService.getGreveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Greve> saveGreve(@RequestBody Greve greve) {
        Greve salvarGreve = greveService.saveGreve(greve);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvarGreve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greve> updateGreve(@PathVariable Long id, @RequestBody Greve updatedGreve) {
        Greve savedGreve = greveService.updateGreve(id, updatedGreve);
        if (savedGreve != null) {
            return ResponseEntity.ok(savedGreve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreve(@PathVariable Long id) {
        boolean isDeleted = greveService.deleteGreve(id);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
