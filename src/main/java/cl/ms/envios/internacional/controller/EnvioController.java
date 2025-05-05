package cl.ms.envios.internacional.controller;

import cl.ms.envios.internacional.dto.ActualizaEstadoDtoRq;
import cl.ms.envios.internacional.dto.EnvioDtoRp;
import cl.ms.envios.internacional.dto.EnvioDtoRq;
import cl.ms.envios.internacional.service.EnvioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public EntityModel<EnvioDtoRp> obtenerEnvios() {
        log.info("Controller - obtenerEnvios()");
//        return ResponseEntity
//                .ok(new EnvioDtoRp("00", "OK", envioService.obtenerEnvios()));
        return EntityModel.of(
                new EnvioDtoRp("00","OK",envioService.obtenerEnvios()),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerEnvios()).withSelfRel()
        );
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public EntityModel<EnvioDtoRp> buscarEnvioById(@Min(1) @PathVariable int id) {
        log.info("Controller - buscarEnvioById()");
//        return ResponseEntity
//                .ok(new EnvioDtoRp("00", "OK", envioService.buscarEnvioById(id)));
        return EntityModel.of(
                new EnvioDtoRp("00","OK",envioService.buscarEnvioById(id)),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).buscarEnvioById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerEnvios()).withRel("all-envios")
        );
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public EntityModel<EnvioDtoRp> agregarEnvio(@Valid @RequestBody EnvioDtoRq rq) {
        log.info("Controller - agregarEnvio()");
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(new EnvioDtoRp("00", "OK", envioService.agregarEnvio(rq)));
        return EntityModel.of(
                new EnvioDtoRp("00","OK",envioService.agregarEnvio(rq)),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).agregarEnvio(rq)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerEnvios()).withRel("all-envios")
        );
    }

    @PutMapping(value = "/estado/{id}", consumes = "application/json", produces = "application/json")
    public EntityModel<EnvioDtoRp> actualizaEstadoEnvio(@Min(1) @PathVariable int id,
                                                           @RequestBody ActualizaEstadoDtoRq rq) {
        log.info("Controller - actualizaEstadoEnvio()");
//        return ResponseEntity
//                .ok(new EnvioDtoRp("00", "OK", envioService.actualizaEstadoEnvio(id, rq)));
        return EntityModel.of(
                new EnvioDtoRp("00","OK",envioService.actualizaEstadoEnvio(id, rq)),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).actualizaEstadoEnvio(id,rq)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerEnvios()).withRel("all-envios")
        );
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public EntityModel<EnvioDtoRp> actualizarEnvio(@Min(1) @PathVariable int id, @RequestBody EnvioDtoRq rq) {
        log.info("Controller - actualizarEnvio()");
//        return ResponseEntity.ok(new EnvioDtoRp("00", "OK", envioService.actualizarEnvio(id, rq)));
        return EntityModel.of(
                new EnvioDtoRp("00","OK",envioService.actualizarEnvio(id, rq)),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).actualizarEnvio(id,rq)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerEnvios()).withRel("all-envios")
        );
    }

    @DeleteMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnvioDtoRp> eliminarEnvio(@Min(1) @PathVariable int id) {
        log.info("Controller - eliminarEnvio()");
        envioService.eliminarEnvio(id);
        return ResponseEntity.noContent().build();
    }
}