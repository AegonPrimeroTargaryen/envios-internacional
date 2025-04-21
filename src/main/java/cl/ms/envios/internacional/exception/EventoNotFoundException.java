package cl.ms.envios.internacional.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EventoNotFoundException extends RuntimeException{
    private final String codigo;
    private final String status;

    public EventoNotFoundException(String msj, String codigo, String status) {
        super(msj);
        this.codigo = codigo;
        this.status = status;
    }
}
