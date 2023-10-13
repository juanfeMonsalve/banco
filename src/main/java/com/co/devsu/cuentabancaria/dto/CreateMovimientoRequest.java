package com.co.devsu.cuentabancaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter
public class CreateMovimientoRequest {

    LocalDateTime fecha;

    String tipoMovimiento;

    Double valor;

    Double saldo;

    int idCuenta;
}
