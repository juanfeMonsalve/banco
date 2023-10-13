package com.co.devsu.cuentabancaria.controller;

import com.co.devsu.cuentabancaria.dto.*;
import com.co.devsu.cuentabancaria.service.CuentaService;
import com.co.devsu.cuentabancaria.service.imp.MovimientosServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/cuenta")
@AllArgsConstructor
public class CuentaController {

    CuentaService cuentaService;

    @GetMapping( "/{idCuenta}")
    public CuentaResponse getCuenta(@PathVariable int idCuenta){
        try {
           CuentaDto cuentaDto = cuentaService.getCuenta(idCuenta);
           return CuentaResponse.builder()
                   .cuentaDto(cuentaDto)
                   .mensaje("Se ejecuto correctamente")
                   .build();
        }catch (Exception e){
            return CuentaResponse.builder()
                    .cuentaDto(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @GetMapping( "getcuentas/{idcliente}")
    public CuentasResponse getCuentas(@PathVariable int idcliente){
        try {
            List<CuentaDto> cuentaDto = cuentaService.getCuentas(idcliente);
            return CuentasResponse.builder()
                    .cuentaDto(cuentaDto)
                    .mensaje("Se ejecuto correctamente")
                    .build();
        }catch (Exception e){
            return CuentasResponse.builder()
                    .cuentaDto(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PostMapping
    public CuentaResponse createCuenta(@RequestBody CuentaDto cuentaDto){
        try {
            CuentaDto cuenta = cuentaService.insertCuenta(cuentaDto);
            return CuentaResponse.builder()
                    .cuentaDto(cuenta)
                    .mensaje("Se ejecuto correctamente")
                    .build();
        }catch (Exception e){
            return CuentaResponse.builder()
                    .cuentaDto(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @DeleteMapping("/{idCuenta}")
    public CuentaResponse deleteCuenta(@PathVariable(name = "idCuenta") int idCuenta){
        try {
            CuentaDto cuenta = cuentaService.deleteCuenta(idCuenta);
            return CuentaResponse.builder()
                    .cuentaDto(cuenta)
                    .mensaje("Se ejecuto correctamente")
                    .build();
        }catch (Exception e){
            return CuentaResponse.builder()
                    .cuentaDto(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PutMapping
    public CuentaResponse updateCuenta(@RequestBody CuentaDto cuentaDto){
        try {
            CuentaDto cuenta =
                    cuentaService.updateCuenta(cuentaDto);
            return CuentaResponse.builder()
                    .cuentaDto(cuenta)
                    .mensaje("Se actualizo correctamente")
                    .build();
        }catch (Exception e){
            return CuentaResponse.builder()
                    .cuentaDto(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
    @PatchMapping
    public CuentaResponse editCuenta(@RequestBody CuentaDto cuentaDto){
        try {
            CuentaDto cuenta =
                    cuentaService.editCuenta(cuentaDto);
            return CuentaResponse.builder()
                    .cuentaDto(cuenta)
                    .mensaje("Se actualizo correctamente")
                    .build();
        }catch (Exception e){
            return CuentaResponse.builder()
                    .cuentaDto(null)
                    .mensaje("Error de ejecucion "+ e.getMessage())
                    .build();
        }
    }
}
