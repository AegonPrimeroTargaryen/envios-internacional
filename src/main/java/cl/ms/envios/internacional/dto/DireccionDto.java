package cl.ms.envios.internacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDto {
    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("comuna")
    private String comuna;

    @JsonProperty("region")
    private String region;

    @JsonProperty("pais")
    private String pais;
}
