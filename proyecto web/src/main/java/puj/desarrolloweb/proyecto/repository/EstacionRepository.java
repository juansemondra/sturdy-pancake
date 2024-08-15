package puj.desarrolloweb.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.desarrolloweb.proyecto.model.Estacion;

public interface EstacionRepository extends JpaRepository<Estacion, Long>{
    
}
