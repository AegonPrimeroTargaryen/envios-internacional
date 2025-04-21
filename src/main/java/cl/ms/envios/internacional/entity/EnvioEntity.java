package cl.ms.envios.internacional.entity;

import cl.ms.envios.internacional.dto.EnvioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ENVIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENVIO")
    private Long idEnvio;

    @Column(name = "FOLIO")
    private String folio;

    @Column(name = "PESO_ARTICULO")
    private double pesoArticulo;

    @Column(name = "VALOR_DECLARADO")
    private double valorDeclarado;

    @Column(name = "ESTADO")
    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_UBICACION")
    private UbicacionEntity ubicacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DESTINO")
    private DireccionEntity destino;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ORIGEN")
    private DireccionEntity origen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_REMITENTE")
    private PersonaEntity remitente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DESTINATARIO")
    private PersonaEntity destinatario;

    public EnvioDto toEnvioDto() {
        return new EnvioDto(Math.toIntExact(this.idEnvio),this.folio,this.pesoArticulo,this.valorDeclarado,
                this.remitente.toPersonaDto(),this.destinatario.toPersonaDto(),this.estado,
                this.ubicacion.toUbicacionDto(),this.origen.toDireccionDto(), this.destino.toDireccionDto());
    }
}
