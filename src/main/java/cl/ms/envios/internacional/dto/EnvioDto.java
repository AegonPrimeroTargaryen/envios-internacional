package cl.ms.envios.internacional.dto;

import cl.ms.envios.internacional.entity.DireccionEntity;
import cl.ms.envios.internacional.entity.EnvioEntity;
import cl.ms.envios.internacional.entity.PersonaEntity;
import cl.ms.envios.internacional.entity.UbicacionEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDto {
    @JsonProperty("id")
    private int id;

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
    @NotEmpty(message = "No puede ser vacio")
    @Pattern(regexp = "^(Recepcionado|En Despacho|En Camino|Entregado)$",
            message = "Valor no permitido: Recepcionado|En Despacho|En Camino|Entregado")
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

    public EnvioEntity toEnvioEntityInsert() {
        EnvioEntity envioEntity = new EnvioEntity();
        envioEntity.setFolio(this.folio);
        envioEntity.setPesoArticulo(this.pesoArticulo);
        envioEntity.setValorDeclarado(this.valorDeclarado);
        envioEntity.setEstado(this.estado);
        envioEntity.setUbicacion(this.ubicacion.toUbicacionEntityInsert());
        envioEntity.setDestino(this.destino.toDireccionEntityInsert());
        envioEntity.setOrigen(this.origen.toDireccionEntityInsert());
        envioEntity.setRemitente(this.remitente.toPersonaEntityInsert());
        envioEntity.setDestinatario(this.destinatario.toPersonaEntityInsert());
        return envioEntity;
    }

    public EnvioEntity toEnvioEntityUpdate(EnvioEntity envioEntity) {
        PersonaEntity remitenteEntity = envioEntity.getRemitente();
        PersonaEntity destinatarioEntity = envioEntity.getDestinatario();
        UbicacionEntity ubicacionEntity = envioEntity.getUbicacion();
        DireccionEntity origenEntity = envioEntity.getOrigen();
        DireccionEntity destinoEntity = envioEntity.getDestino();

        envioEntity.setFolio(this.folio);
        envioEntity.setPesoArticulo(this.pesoArticulo);
        envioEntity.setValorDeclarado(this.valorDeclarado);
        envioEntity.setEstado(this.estado);
        envioEntity.setUbicacion(this.ubicacion.toUbicacionEntityUpdate(ubicacionEntity));
        envioEntity.setDestino(this.destino.toDireccionEntityUpdate(destinoEntity));
        envioEntity.setOrigen(this.origen.toDireccionEntityUpdate(origenEntity));
        envioEntity.setRemitente(this.remitente.toPersonaEntityUpdate(remitenteEntity));
        envioEntity.setDestinatario(this.destinatario.toPersonaEntityUpdate(destinatarioEntity));
        return envioEntity;
    }
}
