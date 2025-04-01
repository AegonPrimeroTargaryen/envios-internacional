package cl.ms.envios.internacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizaEstadoDtoRq {
    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Pattern(regexp = "^(Recepcionado|En Despacho|En Camino|Entregado)$",
            message = "Valor no permitido: Recepcionado|En Despacho|En Camino|Entregado")
    @JsonProperty("estado")
    private String estado;
}
