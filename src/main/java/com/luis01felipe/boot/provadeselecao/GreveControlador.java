package com.luis01felipe.boot.provadeselecao;

import com.luis01felipe.boot.provadeselecao.exceptions.InvalidRequestException;
import com.luis01felipe.boot.provadeselecao.exceptions.MissingIdException;
import com.luis01felipe.boot.provadeselecao.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/greve")
@Validated
public class GreveControlador {
    private final GreveServico greveService;

    @GetMapping
    public ResponseEntity<List<Greve>> getAllGreve() {
        List<Greve> greves = greveService.getAllGreves();

        if (greves.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(greves, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greve> getGreveById(@PathVariable(required = false) Long id) {
        if (id == null || id <= 0) {
            throw new MissingIdException("Por favor, especifique um ID.");
        }

        return greveService.getGreveById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Greve not found with id " + id));
    }

    @PostMapping
    public ResponseEntity<Greve> saveGreve(@RequestBody @Valid Greve greve) {
        Greve salvarGreve = greveService.saveGreve(greve);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvarGreve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greve> updateGreve(@PathVariable(required = false) Long id, @RequestBody @Valid Greve greve) {
        if (id == null || id <= 0) {
            throw new MissingIdException("Por favor, especifique um ID.");
        }
        if (!greveService.existsById(id)) {
            throw new ResourceNotFoundException("Greve not found with id " + id);
        }
        Greve updatedGreve = greveService.updateGreve(id, greve);
        return ResponseEntity.ok(updatedGreve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreve(@PathVariable(required = false) Long id) {
        if (id == null || id <= 0) {
            throw new MissingIdException("Por favor, especifique um ID.");
        }
        if (!greveService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        greveService.deleteGreve(id);
        return ResponseEntity.noContent().build();
    }
}
