package com.co.devsu.cuentabancaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "movimientos")
@Getter @Setter
public class Movimientos {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "fecha")
    LocalDateTime fecha;

    @Column(name = "tipomovimiento")
    String tipoMovimiento;

    @Column(name = "valor")
    Double valor;

    @Column(name = "saldo")
    Double saldo;

    @Column(name = "idcuenta")
    int idCuenta;
}
