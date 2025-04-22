package cl.ms.envios.internacional.service;

import cl.ms.envios.internacional.dto.ActualizaEstadoDtoRq;
import cl.ms.envios.internacional.dto.EnvioDto;
import cl.ms.envios.internacional.dto.EnvioDtoRq;

import java.util.List;

public interface EnvioService {
    List<EnvioDto> obtenerEnvios();
    List<EnvioDto> buscarEnvioById(int id);
    List<EnvioDto> agregarEnvio(EnvioDtoRq rq);
    List<EnvioDto> actualizaEstadoEnvio(int idEnvio, ActualizaEstadoDtoRq rq);
    void eliminarEnvio(int idEnvio);
    List<EnvioDto> actualizarEnvio(int id, EnvioDtoRq rq);
}
