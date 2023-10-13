package com.co.devsu.cuentabancaria.controller;

import com.co.devsu.cuentabancaria.dto.CreateMovimientoRequest;
import com.co.devsu.cuentabancaria.dto.GetMovimientosResponse;
import com.co.devsu.cuentabancaria.dto.MovimientosDto;
import com.co.devsu.cuentabancaria.dto.MovimientosResponse;
import com.co.devsu.cuentabancaria.service.MovimientosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping(value = "/movimientos")
@RestController
@AllArgsConstructor
public class MovimientosController {


    MovimientosService movimientosService;

    @GetMapping("/{idCuenta}")
    public GetMovimientosResponse getMovimiento(@PathVariable   int idCuenta){
        try {
           List<MovimientosDto> movimientosDtoList = movimientosService.getMovimientos(idCuenta);
           return GetMovimientosResponse.builder()
                   .movimientos(movimientosDtoList)
                   .mensaje("Se ejecuto correctamente")
                   .build();
        }catch (Exception e){
            return GetMovimientosResponse.builder()
                    .movimientos(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @GetMapping("getmovimientosbyfecha/{idCuenta}/{fechaIni}/{fechaFin}")
    public GetMovimientosResponse getMovimientosbyFechas(@PathVariable   int idCuenta,
                                                         @PathVariable LocalDateTime fechaIni,
                                                         @PathVariable   LocalDateTime fechaFin){
        try {
            List<MovimientosDto> movimientosDtoList =
                    movimientosService.getMovimientosByFechas(idCuenta,fechaIni,fechaFin);
            return GetMovimientosResponse.builder()
                    .movimientos(movimientosDtoList)
                    .mensaje("Se ejecuto correctamente")
                    .build();
        }catch (Exception e){
            return GetMovimientosResponse.builder()
                    .movimientos(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PostMapping
    public MovimientosResponse createMovimiento(@RequestBody CreateMovimientoRequest createMovimientoRequest){
        try {
            MovimientosDto movimientosDto =
                    movimientosService.insertMovimientos(createMovimientoRequest);
            return MovimientosResponse.builder()
                    .movimientos(movimientosDto)
                    .mensaje("Se creo correctamente")
                    .build();
        }catch (Exception e){
            return MovimientosResponse.builder()
                    .movimientos(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @DeleteMapping("/{idMovimiento}")
    public MovimientosResponse deleteMovimeinto(@PathVariable(name = "idMovimiento") int idMovimiento){
        try {
            MovimientosDto movimientosDto =
                    movimientosService.deleteMovimientos(idMovimiento);
            return MovimientosResponse.builder()
                    .movimientos(movimientosDto)
                    .mensaje("Se elimino correctamente")
                    .build();
        }catch (Exception e){
            return MovimientosResponse.builder()
                    .movimientos(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PutMapping
    public MovimientosResponse updateMovimiento(@RequestBody MovimientosDto movimiento){
        try {
            MovimientosDto movimientosDto =
                    movimientosService.updateMovimientos(movimiento);
            return MovimientosResponse.builder()
                    .movimientos(movimientosDto)
                    .mensaje("Se actualizo correctamente")
                    .build();
        }catch (Exception e){
            return MovimientosResponse.builder()
                    .movimientos(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PatchMapping
    public MovimientosResponse editMovimiento(@RequestBody MovimientosDto movimiento){
        try {
            MovimientosDto movimientosDto =
                    movimientosService.editMovimientos(movimiento);
            return MovimientosResponse.builder()
                    .movimientos(movimientosDto)
                    .mensaje("Se actualizo correctamente")
                    .build();
        }catch (Exception e){
            return MovimientosResponse.builder()
                    .movimientos(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
}
