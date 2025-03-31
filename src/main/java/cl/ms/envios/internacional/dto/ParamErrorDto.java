package cl.ms.envios.internacional.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamErrorDto {
    private String campo;
    private String error;
}
