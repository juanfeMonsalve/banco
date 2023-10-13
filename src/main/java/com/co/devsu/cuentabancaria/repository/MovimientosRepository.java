package com.co.devsu.cuentabancaria.repository;

import com.co.devsu.cuentabancaria.model.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos,Integer> {
    @Query(nativeQuery = true,
            value = "select * from movimientos where idcuenta = ?1 order by fecha desc")
    List<Movimientos> getMovimientosByCuenta(int idCuenta);

    @Query(nativeQuery = true,
            value = "select * from movimientos where idcuenta = ?1 and fecha between ?2 and ?3 order by fecha desc")
    List<Movimientos> getMovimientosByFechas(int idCuenta, LocalDateTime fechaIni, LocalDateTime fechaFin);
}
