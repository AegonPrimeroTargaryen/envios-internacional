package cl.ms.envios.internacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("folio")
    private String folio;

    @JsonProperty("pesoArticulo")
    private double pesoArticulo;

    @JsonProperty("valorDeclarado")
    private double valorDeclarado;

    @JsonProperty("remitente")
    private PersonaDto remitente;

    @JsonProperty("destinatario")
    private PersonaDto destinatario;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("ubicacion")
    private UbicacionDto ubicacion;

    @JsonProperty("origen")
    private DireccionDto origen;

    @JsonProperty("destino")
    private DireccionDto destino;
}
