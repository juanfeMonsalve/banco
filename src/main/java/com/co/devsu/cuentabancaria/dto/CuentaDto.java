package com.co.devsu.cuentabancaria.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter
public class CuentaDto {
    Integer id;
    String numeroCuenta;
    String tipoCuenta;
    Double saldoIncial;
    String estado;
    int idCliente;
}
