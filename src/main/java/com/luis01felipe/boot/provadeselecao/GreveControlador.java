package com.luis01felipe.boot.provadeselecao;

import com.luis01felipe.boot.provadeselecao.exceptions.*;
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
        validateStringFields(greve);
        validateDataFormats(greve);
        validateNumberField(greve);
        Greve salvarGreve = greveService.saveGreve(greve);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvarGreve);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Greve> updateGreve(@PathVariable Long id, @RequestBody @Valid Greve greve) {
        if (id == null || id <= 0) {
            throw new MissingIdException("Por favor, especifique um ID.");
        }
        if (!greveService.existsById(id)) {
            throw new ResourceNotFoundException("Greve not found with id " + id);
        }

        validateStringFields(greve);
        validateDataFormats(greve);
        validateNumberField(greve);
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

    private void validateStringFields(Greve greve) {
        // Verifica se os campos de string estão vazios ou contém apenas espaços
        if (greve.getMotivo() != null && greve.getMotivo().trim().isEmpty()) {
            throw new InvalidStringFormatException("O campo motivo não pode estar vazio.");
        }
        if (greve.getCategoriaTrabalhadores() != null && greve.getCategoriaTrabalhadores().trim().isEmpty()) {
            throw new InvalidStringFormatException("O campo categoriaTrabalhadores não pode estar vazio.");
        }
        if (greve.getSindicatoResponsavel() != null && greve.getSindicatoResponsavel().trim().isEmpty()) {
            throw new InvalidStringFormatException("O campo sindicatoResponsavel não pode estar vazio.");
        }
        if (greve.getLocal() != null && greve.getLocal().trim().isEmpty()) {
            throw new InvalidStringFormatException("O campo local não pode estar vazio.");
        }
    }


    private void validateDataFormats(Greve greve) {
        if (!greve.getDataInicio().matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new InvalidDateFormatException("O formato de data está errado, ele deve estar como: ano-mês-dia");
        }
        if (!greve.getDataFim().matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new InvalidDateFormatException("O formato de data está errado, ele deve estar como: ano-mês-dia");
        }
    }

    private void validateNumberField(Greve greve) {
        if (greve.getNumeroTrabalhadores() == null) {
            throw new InvalidNumberFormatException("Por favor digite um número inteiro, evite \"\" e '' ");
        }
    }
}
