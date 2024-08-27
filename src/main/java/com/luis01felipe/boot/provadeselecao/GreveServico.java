package com.luis01felipe.boot.provadeselecao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GreveServico {

    private final GreveRepositorio repositorio;

    // Endpoint que age como 'SELECT *'
    public List<Greve> getAllGreves() {
        return repositorio.findAll();
    }

    // Endpoint que age como 'SELECT com WHERE 'id' = valor'
    public Optional<Greve> getGreveById(Long id) {
        return repositorio.findById(id);
    }

    // Endpoint que age como 'INSERT INTO'
    public Greve saveGreve(Greve greve) {
        return repositorio.save(greve);
    }

    // Endpoint que age como 'UPDATE com WHERE 'id' = valor'
    public Greve updateGreve(Long id, Greve updatedGreve) {
        if (repositorio.existsById(id)) {
            updatedGreve.setId(id);
            return repositorio.save(updatedGreve);
        } else {
            return null;
        }
    }

    // Endpoint que age como 'DELETE com WHERE 'id' = valor'
    public boolean deleteGreve(Long id) {
        Optional<Greve> greve = repositorio.findById(id);
        if (greve.isPresent()) {
            repositorio.delete(greve.get());
            return true;
        } else {
            return false;
        }
    }

}
