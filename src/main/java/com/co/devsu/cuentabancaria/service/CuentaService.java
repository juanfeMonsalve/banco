package com.co.devsu.cuentabancaria.service;

import com.co.devsu.cuentabancaria.dto.CuentaDto;

import java.util.List;

public interface CuentaService {
    CuentaDto getCuenta(int idCuenta);
    CuentaDto deleteCuenta(int idCuenta) throws Exception;
    CuentaDto updateCuenta(CuentaDto cuentaDto) throws Exception;
    CuentaDto editCuenta(CuentaDto cuentaDto) throws Exception;
    CuentaDto insertCuenta(CuentaDto cuentaDto);
     List<CuentaDto> getCuentas(int idCliente);
}
