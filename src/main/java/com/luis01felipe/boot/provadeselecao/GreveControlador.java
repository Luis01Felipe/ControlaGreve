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
    public List<Greve> getAllGreve() {
        return greveService.getAllGreves();
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
    public void deleteGreve(@PathVariable Long id) {
        greveService.deleteGreve(id);
    }
}
