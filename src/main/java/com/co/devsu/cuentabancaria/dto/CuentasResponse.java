package com.co.devsu.cuentabancaria.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@Builder
public class CuentasResponse {
    List<CuentaDto> cuentaDto;
    String mensaje;
}
