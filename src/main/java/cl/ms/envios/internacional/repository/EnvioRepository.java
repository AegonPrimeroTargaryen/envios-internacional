package cl.ms.envios.internacional.repository;

import cl.ms.envios.internacional.entity.EnvioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<EnvioEntity, Long> {
}
