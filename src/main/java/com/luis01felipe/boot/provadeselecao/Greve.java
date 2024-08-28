package com.luis01felipe.boot.provadeselecao;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Greve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long        id;
    LocalDate   dataInicio;
    LocalDate   dataFim;
    String      motivo;
    String      categoriaTrabalhadores;
    String      sindicatoResponsavel;
    Integer     numeroTrabalhadores;
    String      local;
}
