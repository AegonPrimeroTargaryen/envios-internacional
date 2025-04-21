package cl.ms.envios.internacional.dto;

import cl.ms.envios.internacional.entity.DireccionEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDto {
    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, message = "Largo minimo de 3 caracteres")
    @Size(max = 100, message = "Largo maximo de 100 caracteres")
    @JsonProperty("direccion")
    private String direccion;

    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, message = "Largo minimo de 3 caracteres")
    @Size(max = 50, message = "Largo maximo de 50 caracteres")
    @JsonProperty("comuna")
    private String comuna;

    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, message = "Largo minimo de 3 caracteres")
    @Size(max = 50, message = "Largo maximo de 50 caracteres")
    @JsonProperty("region")
    private String region;

    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, message = "Largo minimo de 3 caracteres")
    @Size(max = 50, message = "Largo maximo de 50 caracteres")
    @JsonProperty("pais")
    private String pais;

    public DireccionEntity toDireccionEntityInsert() {
        DireccionEntity direccionEntity = new DireccionEntity();
        direccionEntity.setDireccion(this.direccion);
        direccionEntity.setComuna(this.comuna);
        direccionEntity.setRegion(this.region);
        direccionEntity.setPais(this.pais);
        return direccionEntity;
    }
}
