package com.co.devsu.cuentabancaria.service;

import com.co.devsu.cuentabancaria.dto.CreateMovimientoRequest;
import com.co.devsu.cuentabancaria.dto.MovimientosDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


public interface MovimientosService {
    List<MovimientosDto> getMovimientos(int idCuenta);
    List<MovimientosDto> getMovimientosByFechas(int idCuenta, LocalDateTime fechaIni, LocalDateTime fechaFin);
    MovimientosDto deleteMovimientos(int idMovimiento) throws Exception;
    MovimientosDto updateMovimientos(MovimientosDto movimiento) throws Exception;
    MovimientosDto editMovimientos(MovimientosDto movimiento) throws Exception;
    MovimientosDto insertMovimientos(CreateMovimientoRequest createMovimientoRequest) throws Exception;
}
