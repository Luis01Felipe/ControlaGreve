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
    private final GreveRepositorio repositorio;

    // Endpoint que age como 'SELECT *'
    @GetMapping
    public List<Greve> getAllGreve() {
        return repositorio.findAll();
    }

    // Endpoint que age como 'SELECT com WHERE 'id' = valor'
    // TODO: Permitir que ele seja um SELECT com WHERE capaz de buscar por qualquer caracteristica
    @GetMapping("/{id}")
    public Greve getGreveById(@PathVariable Long id) {
        return repositorio.findById(id).get();
    }

    // Endpoint que age como 'INSERT INTO'
    @PostMapping
    public ResponseEntity<Greve> saveGreve(@RequestBody Greve greve) {
        Greve salvarGreve = repositorio.save(greve);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvarGreve);
    }

    // Endpoint que age como 'UPDATE'
    @PutMapping("/{id}")
    public ResponseEntity<Greve> updateGreve(@PathVariable Long id, @RequestBody Greve updatedGreve) {
        if (repositorio.existsById(id)) {
            updatedGreve.setId(id);
            Greve savedGreve = repositorio.save(updatedGreve);
            return ResponseEntity.ok(savedGreve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint que age como 'DELETE com WHERE 'id' = valor'
    @DeleteMapping("/{id}")
    public void deleteGreve(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}
