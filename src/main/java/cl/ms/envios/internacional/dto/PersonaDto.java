package cl.ms.envios.internacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("nombreCompleto")
    private String nombreCompleto;

    @JsonProperty("direccion")
    private DireccionDto direccion;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("correo")
    private String correo;
}
