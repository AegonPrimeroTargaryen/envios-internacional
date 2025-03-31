package cl.ms.envios.internacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDtoRq {
    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, max = 30, message = "Largo minimo de 3 y maximo de 30")
    @JsonProperty("folio")
    private String folio;

    @Min(value = 1, message = "Peso minimo es de 1 Kilo")
    @JsonProperty("pesoArticulo")
    private double pesoArticulo;

    @Min(value = 5, message = "Precio minimo es de $5")
    @JsonProperty("valorDeclarado")
    private double valorDeclarado;

    @NotNull(message = "No puede ser null")
    @Valid
    @JsonProperty("remitente")
    private PersonaDto remitente;

    @NotNull(message = "No puede ser null")
    @Valid
    @JsonProperty("destinatario")
    private PersonaDto destinatario;

    @NotNull(message = "No puede ser null")
    @JsonProperty("estado")
    private String estado;

    @NotNull(message = "No puede ser null")
    @Valid
    @JsonProperty("ubicacion")
    private UbicacionDto ubicacion;

    @NotNull(message = "No puede ser null")
    @Valid
    @JsonProperty("origen")
    private DireccionDto origen;

    @NotNull(message = "No puede ser null")
    @Valid
    @JsonProperty("destino")
    private DireccionDto destino;
}
