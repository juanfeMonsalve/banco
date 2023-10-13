package com.co.devsu.cuentabancaria.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Builder
public class MovimientosResponse {
    MovimientosDto movimientos;
    String mensaje;
}
