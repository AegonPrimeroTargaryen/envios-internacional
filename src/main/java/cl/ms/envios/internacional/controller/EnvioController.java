package cl.ms.envios.internacional.controller;

import cl.ms.envios.internacional.dto.ActualizaEstadoDtoRq;
import cl.ms.envios.internacional.dto.EnvioDtoRp;
import cl.ms.envios.internacional.dto.EnvioDtoRq;
import cl.ms.envios.internacional.service.EnvioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("${api.envio.internacional.base.url}")
public class EnvioController {
    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> obtenerEnvios() {
        log.info("Controller - obtenerEnvios()");
        return ResponseEntity
                .ok(new EnvioDtoRp("00", "OK", envioService.obtenerEnvios()));
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> buscarEnvioById(@Min(1) @PathVariable int id) {
        log.info("Controller - buscarEnvioById()");
        return ResponseEntity
                .ok(new EnvioDtoRp("00", "OK", envioService.buscarEnvioById(id)));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> agregarEnvio(@Valid @RequestBody EnvioDtoRq rq) {
        log.info("Controller - agregarEnvio()");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new EnvioDtoRp("00", "OK", envioService.agregarEnvio(rq)));
    }

    @PutMapping(value = "/estado/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> actualizaEstadoEnvio(@Min(1) @PathVariable int id,
                                                           @RequestBody ActualizaEstadoDtoRq rq) {
        log.info("Controller - actualizaEstadoEnvio()");
        return ResponseEntity
                .ok(new EnvioDtoRp("00", "OK", envioService.actualizaEstadoEnvio(id, rq)));
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> actualizarEnvio(@Min(1) @PathVariable int id, @RequestBody EnvioDtoRq rq) {
        log.info("Controller - actualizarEnvio()");
        return ResponseEntity.ok(new EnvioDtoRp("00", "OK", envioService.actualizarEnvio(id, rq)));
    }

    @DeleteMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> eliminarEnvio(@Min(1) @PathVariable int id) {
        log.info("Controller - eliminarEnvio()");
        envioService.eliminarEnvio(id);
        return ResponseEntity.noContent().build();
    }
}