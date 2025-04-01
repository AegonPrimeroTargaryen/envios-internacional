package cl.ms.envios.internacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    @JsonProperty("id")
    private int id;

    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 5, message = "Ingresar nombre completo")
    @Size(max = 100, message = "Largo maximo de 100")
    @JsonProperty("nombreCompleto")
    private String nombreCompleto;

    @NotNull(message = "No puede ser null")
    @Valid
    @JsonProperty("direccion")
    private DireccionDto direccion;

    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Pattern(regexp = "^\\+56\\d{9}$", message = "Formato: +56XXXXXXXXX")
    @JsonProperty("telefono")
    private String telefono;

    @NotNull(message = "No puede ser null")
    @NotEmpty(message = "No puede ser vacio")
    @Email(message = "Correo incorrecto")
    @JsonProperty("correo")
    private String correo;
}
