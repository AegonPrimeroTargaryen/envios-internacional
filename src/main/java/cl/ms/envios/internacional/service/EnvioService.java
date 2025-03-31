package cl.ms.envios.internacional.service;

import cl.ms.envios.internacional.dto.EnvioDto;
import cl.ms.envios.internacional.dto.EnvioDtoRp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvioService {
    private final List<EnvioDto> envios = new ArrayList<>();

    public ResponseEntity<EnvioDtoRp> obtenerEnvios(){
        return ResponseEntity.ok(new EnvioDtoRp("00","OK",envios));
    }

    public ResponseEntity<EnvioDtoRp> buscarEnvioById(int id){
        final List<EnvioDto> envioDtos = new ArrayList<>();
        envios.stream().filter(envioDto -> envioDto.getId() == id).findFirst().ifPresent(envioDtos::add);
        return ResponseEntity.ok(new EnvioDtoRp("00","OK",envioDtos));
    }
}
