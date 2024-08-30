package io.github.luis01felipe.boot.provadeselecao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Greve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // Validação para formato de data
    @NotNull
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "O formato de data está errado, ele deve estar como: ano-mês-dia")
    private String dataInicio;

    @NotNull
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "O formato de data está errado, ele deve estar como: ano-mês-dia")
    private String dataFim;

    private String motivo;
    private String categoriaTrabalhadores;
    private String sindicatoResponsavel;

    // Validação para número de trabalhadores
    @NotNull(message = "Por favor, insira o número de trabalhadores.")
    private Integer numeroTrabalhadores;

    private String local;
}
