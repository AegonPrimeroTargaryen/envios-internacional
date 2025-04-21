package cl.ms.envios.internacional.entity;

import cl.ms.envios.internacional.dto.DireccionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "DIRECCION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECCION")
    private long id;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "COMUNA")
    private String comuna;

    @Column(name = "REGION")
    private String region;

    @Column(name = "PAIS")
    private String pais;

    public DireccionDto toDireccionDto() {
        return new DireccionDto(direccion, comuna, region, pais);
    }
}
