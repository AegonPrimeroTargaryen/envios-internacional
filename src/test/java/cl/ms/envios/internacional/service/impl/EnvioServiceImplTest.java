package cl.ms.envios.internacional.service.impl;

import cl.ms.envios.internacional.dto.EnvioDto;
import cl.ms.envios.internacional.entity.DireccionEntity;
import cl.ms.envios.internacional.entity.EnvioEntity;
import cl.ms.envios.internacional.entity.PersonaEntity;
import cl.ms.envios.internacional.entity.UbicacionEntity;
import cl.ms.envios.internacional.repository.EnvioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EnvioServiceImplTest {
    @InjectMocks
    private EnvioServiceImpl envioServiceImpl;

    @Mock
    private EnvioRepository envioRepository;

    @Test
    void getEnvios() {
        UbicacionEntity ubicacion = new UbicacionEntity();
        ubicacion.setIdUbicacion(1L);

        PersonaEntity persona = new PersonaEntity();
        persona.setIdPersona(1L);

        DireccionEntity direccion = new DireccionEntity();
        direccion.setId(1L);
        persona.setDireccion(direccion);

        EnvioEntity envioEntity = new EnvioEntity();
        envioEntity.setIdEnvio(1L);
        envioEntity.setEstado("OK");
        envioEntity.setRemitente(persona);
        envioEntity.setOrigen(direccion);
        envioEntity.setDestino(direccion);
        envioEntity.setDestinatario(persona);
        envioEntity.setUbicacion(ubicacion);

        List<EnvioEntity> list = new ArrayList<>();
        list.add(envioEntity);

        Mockito.when(envioRepository.findAll()).thenReturn(list);

        List<EnvioDto> actual = envioServiceImpl.obtenerEnvios();

        Assertions.assertEquals(list.getFirst().toEnvioDto().getEstado(),actual.getFirst().getEstado());
    }

    @Test
    void getEnvioById() {
        UbicacionEntity ubicacion = new UbicacionEntity();
        ubicacion.setIdUbicacion(1L);

        PersonaEntity persona = new PersonaEntity();
        persona.setIdPersona(1L);

        DireccionEntity direccion = new DireccionEntity();
        direccion.setId(1L);
        persona.setDireccion(direccion);

        EnvioEntity envioEntity = new EnvioEntity();
        envioEntity.setIdEnvio(1L);
        envioEntity.setEstado("OK");
        envioEntity.setRemitente(persona);
        envioEntity.setOrigen(direccion);
        envioEntity.setDestino(direccion);
        envioEntity.setDestinatario(persona);
        envioEntity.setUbicacion(ubicacion);

        Mockito.lenient().when(envioRepository.findById(1L)).thenReturn(Optional.of(envioEntity));

        List<EnvioDto> actual = envioServiceImpl.buscarEnvioById(1);

        Assertions.assertEquals(envioEntity.getEstado(),actual.getFirst().getEstado());
    }
}
