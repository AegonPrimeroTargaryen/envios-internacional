package cl.ms.envios.internacional.service;

import cl.ms.envios.internacional.dto.ActualizaEstadoDtoRq;
import cl.ms.envios.internacional.dto.EnvioDto;
import cl.ms.envios.internacional.dto.EnvioDtoRp;
import cl.ms.envios.internacional.dto.EnvioDtoRq;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvioService {
    private int idEnvio = 1;
    private final List<EnvioDto> envios = new ArrayList<>();

    public ResponseEntity<EnvioDtoRp> obtenerEnvios(){
        return ResponseEntity.ok(new EnvioDtoRp("00","OK",envios));
    }

    public ResponseEntity<EnvioDtoRp> buscarEnvioById(int id){
        List<EnvioDto> envioDtos = new ArrayList<>();
        envios.stream().filter(envioDto -> envioDto.getId() == id).findFirst().ifPresent(envioDtos::add);
        return ResponseEntity.ok(new EnvioDtoRp("00","OK",envioDtos));
    }

    public ResponseEntity<EnvioDtoRp> agregarEnvio(EnvioDtoRq rq){
        int generarId = idEnvio++;
        List<EnvioDto> enviosDto = new ArrayList<>();
        EnvioDto envioDto = new EnvioDto();
        envioDto.setId(generarId);
        envioDto.setFolio(rq.getFolio());
        envioDto.setPesoArticulo(rq.getPesoArticulo());
        envioDto.setValorDeclarado(rq.getValorDeclarado());
        envioDto.setEstado(rq.getEstado());
        envioDto.setRemitente(rq.getRemitente());
        envioDto.setDestinatario(rq.getDestinatario());
        envioDto.setUbicacion(rq.getUbicacion());
        envioDto.setOrigen(rq.getOrigen());
        envioDto.setDestino(rq.getDestino());
        envios.add(envioDto);
        enviosDto.add(envioDto);

        return ResponseEntity.ok(new EnvioDtoRp("00","OK",enviosDto));
    }

    public ResponseEntity<EnvioDtoRp> actualizaEstadoEnvio(int idEnvio, ActualizaEstadoDtoRq rq){
        if (envios.stream().noneMatch(envio -> envio.getId() == idEnvio)){
            return ResponseEntity.notFound().build();
        }
        List<EnvioDto> enviosDto = new ArrayList<>();
        for (EnvioDto envioDto : envios) {
            if (envioDto.getId() == idEnvio){
                envioDto.setEstado(rq.getEstado());
                enviosDto.add(envioDto);
                break;
            }
        }
        return ResponseEntity.ok(new EnvioDtoRp("00","OK",enviosDto));
    }
}
