package com.co.devsu.cuentabancaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cuenta")
@Getter  @Setter
public class Cuenta {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "numerocuenta")
    String numeroCuenta;
    @Column(name = "tipocuenta")
    String tipoCuenta;
    @Column(name = "saldoinicial")
    Double saldoIncial;
    @Column(name = "estado")
    String estado;
    @Column(name = "idcliente")
    int idCliente;
}
