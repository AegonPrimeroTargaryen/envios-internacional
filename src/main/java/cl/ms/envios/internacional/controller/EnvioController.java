package cl.ms.envios.internacional.controller;

import cl.ms.envios.internacional.dto.ActualizaEstadoDtoRq;
import cl.ms.envios.internacional.dto.EnvioDtoRp;
import cl.ms.envios.internacional.dto.EnvioDtoRq;
import cl.ms.envios.internacional.service.EnvioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.envio.internacional.base.url}")
public class EnvioController {
    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> obtenerEnvios(){
        return envioService.obtenerEnvios();
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> buscarEnvioById(@Min(1) @PathVariable int id){
        return envioService.buscarEnvioById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> agregarEnvio(@Valid @RequestBody EnvioDtoRq rq){
        return envioService.agregarEnvio(rq);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> actualizaEstadoEnvio(@Min(1) @PathVariable int id,
                                                  @RequestBody ActualizaEstadoDtoRq rq){
        return envioService.actualizaEstadoEnvio(id,rq);
    }
}
