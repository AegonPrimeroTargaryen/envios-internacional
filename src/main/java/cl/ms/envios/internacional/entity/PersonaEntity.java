package cl.ms.envios.internacional.entity;

import cl.ms.envios.internacional.dto.PersonaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PERSONA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")
    private Long idPersona;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "CORREO")
    private String correo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DIRECCION")
    private DireccionEntity direccion;

    public PersonaDto toPersonaDto() {
        return new PersonaDto(Math.toIntExact(this.idPersona),this.nombreCompleto,
                this.direccion.toDireccionDto(),this.telefono,this.correo);
    }
}
