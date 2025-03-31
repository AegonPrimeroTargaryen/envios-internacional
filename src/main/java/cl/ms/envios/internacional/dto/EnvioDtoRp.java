package cl.ms.envios.internacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDtoRp extends ResponseDto {
    @JsonProperty("data")
    private List<EnvioDto> envios = new ArrayList<>();

    public EnvioDtoRp(String codigo, String detalle, List<EnvioDto> envios){
        super(codigo, detalle);
        this.envios=envios;
    }
}
