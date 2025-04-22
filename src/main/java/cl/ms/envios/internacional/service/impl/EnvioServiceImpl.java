package cl.ms.envios.internacional.service.impl;

import cl.ms.envios.internacional.dto.ActualizaEstadoDtoRq;
import cl.ms.envios.internacional.dto.EnvioDto;
import cl.ms.envios.internacional.dto.EnvioDtoRp;
import cl.ms.envios.internacional.dto.EnvioDtoRq;
import cl.ms.envios.internacional.entity.EnvioEntity;
import cl.ms.envios.internacional.exception.EventoNotFoundException;
import cl.ms.envios.internacional.repository.EnvioRepository;
import cl.ms.envios.internacional.service.EnvioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EnvioServiceImpl implements EnvioService {
    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioServiceImpl(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public List<EnvioDto> obtenerEnvios(){
        log.info("Service - obtenerEnvios() - init");
        List<EnvioDto> enviosDto = new ArrayList<>();
        envioRepository.findAll().forEach(envio -> enviosDto.add(envio.toEnvioDto()));
        logCantidadEnvios(enviosDto.size());
        log.info("Service - obtenerEnvios() - end");
        return enviosDto;
    }

    @Override
    public List<EnvioDto> buscarEnvioById(int id){
        log.info("Service - buscarEnvioById() - init");
        List<EnvioDto> envioDtos = new ArrayList<>();
        envioRepository.findById((long) id).ifPresent(envio -> envioDtos.add(envio.toEnvioDto()));
        logCantidadEnvios(envioDtos.size());
        log.info("Service - buscarEnvioById() - end");
        return envioDtos;
    }

    @Override
    public List<EnvioDto> agregarEnvio(EnvioDtoRq rq){
        log.info("Service - agregarEnvio() - init");
        List<EnvioDto> enviosDto = new ArrayList<>();
        enviosDto.add(envioRepository.save(rq.toEnvioEntityInsert()).toEnvioDto());
        log.info("Service - agregarEnvio() - end");
        return enviosDto;
    }

    @Override
    public List<EnvioDto> actualizaEstadoEnvio(int idEnvio, ActualizaEstadoDtoRq rq){
        log.info("Service - actualizaEstadoEnvio() - init");
        List<EnvioDto> enviosDto = new ArrayList<>();
        Optional<EnvioEntity> result = envioRepository.findById((long) idEnvio);
        if (result.isEmpty()) throw new EventoNotFoundException("Envio no encontrado","01","NOK");
        EnvioEntity actual = result.get();
        actual.setEstado(rq.getEstado());
        enviosDto.add(envioRepository.save(actual).toEnvioDto());
        log.info("Service - actualizaEstadoEnvio() - end");
        return enviosDto;
    }

    @Override
    public void eliminarEnvio(int idEnvio){
        log.info("Service - eliminarEnvio() - init");
        Optional<EnvioEntity> result = envioRepository.findById((long) idEnvio);
        if (result.isEmpty()) throw new EventoNotFoundException("Envio no encontrado","01","NOK");
        envioRepository.deleteById((long) idEnvio);
        log.info("Service - eliminarEnvio() - end");
    }

    @Override
    public List<EnvioDto> actualizarEnvio(int id, EnvioDtoRq rq){
        log.info("Service - actualizarEnvio() - init");
        List<EnvioDto> enviosDto = new ArrayList<>();
        Optional<EnvioEntity> result = envioRepository.findById((long) id);
        if (result.isEmpty()) throw new EventoNotFoundException("Envio no encontrado","01","NOK");
        EnvioEntity actual = result.get();
        enviosDto.add(envioRepository.save(rq.toEnvioEntityUpdate(actual)).toEnvioDto());
        logCantidadEnvios(enviosDto.size());
        log.info("Service - actualizarEnvio() - end");
        return enviosDto;
    }

    private void logCantidadEnvios(int size){
        log.info("Registros encontrados: {}",size);
    }
}
