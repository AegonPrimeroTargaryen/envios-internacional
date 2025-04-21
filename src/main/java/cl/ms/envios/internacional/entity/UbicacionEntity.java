package cl.ms.envios.internacional.entity;

import cl.ms.envios.internacional.dto.UbicacionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "UBICACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbicacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UBICACION")
    private Long idUbicacion;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "DETALLE")
    private String detalle;

    public UbicacionDto toUbicacionDto(){
        return new UbicacionDto(this.pais, this.detalle);
    }
}
