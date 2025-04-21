package cl.ms.envios.internacional.dto;

import cl.ms.envios.internacional.entity.UbicacionEntity;
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
public class UbicacionDto {
    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, max = 50, message = "Largo minimo de 3 y maximo de 50")
    @JsonProperty("pais")
    private String pais;

    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, max = 200, message = "Largo minimo de 3 y maximo de 200")
    @JsonProperty("detalle")
    private String detalle;

    public UbicacionEntity toUbicacionEntityInsert() {
        UbicacionEntity ubicacionEntity = new UbicacionEntity();
        ubicacionEntity.setPais(pais);
        ubicacionEntity.setDetalle(detalle);
        return ubicacionEntity;
    }
}
